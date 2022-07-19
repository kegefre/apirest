package br.com.tiacademy.catalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.catalogo.entity.Gravadora;
import br.com.tiacademy.catalogo.repository.GravadoraRepository;

@RestController
@RequestMapping("/gravadora")
public class GravadoraController extends ControllerCatalogo<Gravadora, Long>{
	@Autowired
	private GravadoraRepository gravadoraRepository;
	@GetMapping
	public List<Gravadora> todasGravadoras() {
		return gravadoraRepository.findAll();
	}
}
