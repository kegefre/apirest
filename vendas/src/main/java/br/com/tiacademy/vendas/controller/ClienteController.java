package br.com.tiacademy.vendas.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.vendas.domain.Cliente;
import br.com.tiacademy.vendas.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listar(){

		List<Cliente> clientes = clienteService.listar();
		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> especifico(@PathVariable("id") Long id){
		
		Cliente resultado = clienteService.porId(id);
		if (Objects.isNull(resultado)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(resultado);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> criar(@RequestBody Cliente vendedor){
		Cliente salvo = clienteService.criar(vendedor);
		return ResponseEntity.ok(salvo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> editar(@PathVariable("id") Long id, @RequestBody Cliente vendedor){
		return ResponseEntity.ok(clienteService.editar(id, vendedor));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
		clienteService.excluir(id);
		return ResponseEntity.ok().build();
		
	}
}
