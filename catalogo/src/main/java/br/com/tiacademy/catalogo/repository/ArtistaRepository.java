package br.com.tiacademy.catalogo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.tiacademy.catalogo.entity.Artista;

@Repository
public interface ArtistaRepository  extends RepositoryCatalogo<Artista, Long>{
	
	@Query("select a from Artista a where a.nome=:nome")
	Artista consultarPeloNome(@Param("nome") String nome);
	
	Artista findByNome(String nome);
	
}
