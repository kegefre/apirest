package br.com.tiacademy.vendas.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.vendas.domain.Vendedor;
import br.com.tiacademy.vendas.service.VendedorService;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping
	public ResponseEntity<List<Vendedor>> listar(){
		
		//var vendedor = new Vendedor();
		List<Vendedor> vendedores = vendedorService.listar();
		return ResponseEntity.ok(vendedores);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Vendedor> especifico(@PathVariable("id") Long id){
		
		//var vendedor = new Vendedor();
		/*Vendedor resultado = vendedores().stream()
		.filter(vendedor->vendedor.getId().equals(id))
		.findFirst()
		.orElse(null);
		*/
		Vendedor resultado = vendedorService.porId(id);
		if (Objects.isNull(resultado)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(resultado);
	}
	/*
	private List<Vendedor> vendedores(){
		
		Vendedor um = new Vendedor();
		um.setId(1L);
		um.setNome("João");
		
		Vendedor dois = new Vendedor();
		dois.setId(2L);
		dois.setNome("Manuel");
		
		List<Vendedor> vendedores =Arrays.asList(um,dois);
		return vendedores;
	}
	*/
	/*public ResponseEntity<String> nomeVendedor(){
		return ResponseEntity.ok("Kellis");
	}
	
	@GetMapping("/nome")
	public String nome(){
		return "Kellis2";
	}
	@GetMapping("/nome/n")
	public String nome3(){
		return "Kellis3";
	}
	*/
	/*public String nomeVendedor() {
		return "Kellis";
	}*/
	
}
