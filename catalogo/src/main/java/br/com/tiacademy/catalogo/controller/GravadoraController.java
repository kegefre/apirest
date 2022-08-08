package br.com.tiacademy.catalogo.controller;

import java.util.List;
import java.util.stream.Collector;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.catalogo.dto.GravadoraDTO;
import br.com.tiacademy.catalogo.entity.Gravadora;
import br.com.tiacademy.catalogo.repository.GravadoraRepository;

@RestController
@RequestMapping("/gravadora")
public class GravadoraController extends ControllerCatalogo<Gravadora, Long>{
//	@Autowired
//	private GravadoraRepository gravadoraRepository;
//	@GetMapping
//	public List<Gravadora> todasGravadoras() {
//		return gravadoraRepository.findAll();
//	}
	

//	@GetMapping("/dto")
//	public ResponseEntity<List<GravadoraDTO>> listaDTO(){
//		List<Gravadora> gravadoras = repository.findAll();
//	
//	
//	List<GravadoraDTO> gravadorasDTO = gravadoras.stream().map(g-> new GravadoraDTO(
//				g.getId(),
//				g.getNome(),
//				g.getAno(),
//				g.getCidade(),
//				g.getUf(),
//				g.getArtistas().stream().map(a -> new ArtistaDTO(a.getId(),a.getNome())).collect(Collector.toList())).collect(Collector.toList()));
//	
//	}
}
