package br.com.tiacademy.catalogo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.catalogo.entity.Artista;
import br.com.tiacademy.catalogo.repository.ArtistaRepository;

@RestController
@RequestMapping("/artista")

public class ArtistController extends ControllerCatalogo<Artista, Long>{

	public ArtistaRepository getRepository() {
		return (ArtistaRepository) this.repository;
	}
	
	@GetMapping("/nome")
	public Artista artistaPorNome() {
		
		return this.getRepository().consultarPeloNome("Gilberto Gil");
		
	}
	
	@GetMapping("/djavan")
	public Artista djavan() {
		
		return this.getRepository().findByNome("Djavan");
		
	}
//	@Autowired
//	private ArtistaRepository artistaRepository;
//	@GetMapping
//	public List<Artista> todosArtistas() {
//		return artistaRepository.findAll();
//	}
	
	//private final ArtistaRepository artistaRepository;
	//
	//public ArtistaController(ArtistaRepository artistaRepository){
	// this.artistaRepository = artistaRepository;
	//}
	
	
}
