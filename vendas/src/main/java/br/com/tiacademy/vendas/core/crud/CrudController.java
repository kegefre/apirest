package br.com.tiacademy.vendas.core.crud;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public abstract class CrudController<T extends CrudDomain<ID>, D, ID> {
	@Autowired
	protected CrudService<T, ID> service;
	
	@Autowired
	protected CrudConverter<T, D> converter;
	
	@GetMapping
	public ResponseEntity<Page<D>> paginada(Pageable pageable) {

		Page<D> listaPaginada = service.paginada(pageable).map(converter::entidadeParaDto);
		
		return ResponseEntity.ok(listaPaginada);
		
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<D>> listar() {

		List<D> listaDto = service.listar().stream().map(converter::entidadeParaDto).collect(Collectors.toList());
		return ResponseEntity.ok(listaDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<D> especifico(@PathVariable("id") ID id) {

		T entidade = service.porId(id);
		if (Objects.isNull(entidade)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(converter.entidadeParaDto(entidade));
	}
	
	@PostMapping
	public ResponseEntity<D> criar(@RequestBody D dto) {
		T entidade=converter.dtoParaEntidade(dto);
		T salvo = service.criar(entidade);
		
		ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();
		
		URI uri = builder.path("/{id}").buildAndExpand(salvo.getId()).toUri();
		
		return ResponseEntity.created(uri).body(converter.entidadeParaDto(entidade));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<D> editar(@PathVariable("id") ID id, @RequestBody D dto) {
		T entidade = converter.dtoParaEntidade(dto);
		T salvo = service.editar(id, entidade);
		return ResponseEntity.ok(converter.entidadeParaDto(salvo));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") ID id) {
		service.excluir(id);
		return ResponseEntity.noContent().build();

	}
}
