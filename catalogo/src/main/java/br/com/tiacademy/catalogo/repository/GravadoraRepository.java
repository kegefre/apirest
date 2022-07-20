package br.com.tiacademy.catalogo.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tiacademy.catalogo.entity.Gravadora;

@Repository
public interface GravadoraRepository extends RepositoryCatalogo<Gravadora, Long> {

}
