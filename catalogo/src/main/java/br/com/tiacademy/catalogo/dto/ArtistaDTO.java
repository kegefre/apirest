package br.com.tiacademy.catalogo.dto;

import br.com.tiacademy.catalogo.entity.Artista;
import br.com.tiacademy.catalogo.entity.Gravadora;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArtistaDTO {
	private Long id;
	private String nome;
}
