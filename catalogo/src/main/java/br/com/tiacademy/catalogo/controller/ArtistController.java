package br.com.tiacademy.catalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.catalogo.entity.Artista;
import br.com.tiacademy.catalogo.repository.ArtistaRepository;

@RestController
@RequestMapping("/artista")

public class ArtistController extends ControllerCatalogo<Artista, Long>{

	
	
	@Autowired
	private ArtistaRepository artistaRepository;
	@GetMapping
	public List<Artista> todosArtistas() {
		return artistaRepository.findAll();
	}
	
	//private final ArtistaRepository artistaRepository;
	//
	//public ArtistaController(ArtistaRepository artistaRepository){
	// this.artistaRepository = artistaRepository;
	//}
	
	
}
