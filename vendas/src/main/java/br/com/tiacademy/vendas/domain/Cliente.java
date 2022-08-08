package br.com.tiacademy.vendas.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.tiacademy.vendas.core.crud.CrudDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Table(name='')
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente implements CrudDomain<Long>, Serializable{
//	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	private String nome;

}
