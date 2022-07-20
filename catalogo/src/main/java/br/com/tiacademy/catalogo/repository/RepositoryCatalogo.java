package br.com.tiacademy.catalogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


//import br.com.tiacademy.catalogo.entity.EntidadeCatalogo;

@NoRepositoryBean
public interface RepositoryCatalogo<T, ID> extends JpaRepository<T, ID> {

}
