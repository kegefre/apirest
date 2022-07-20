package br.com.tiacademy.catalogo.controller;

import java.util.List;

import br.com.tiacademy.catalogo.repository.RepositoryCatalogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public abstract class ControllerCatalogo<T, ID> {

	@Autowired
	protected RepositoryCatalogo<T, ID> repository;
	
	@GetMapping
	public List<T> lista(){
		return repository.findAll();
	}
	
}
