package br.com.tiacademy.catalogo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.tiacademy.catalogo.enume.Categoria;

public class EtiquetaServiceTest {

	@Test
	public void deveConterNoveDigitos() {
		EtiquetaService etiquetaService = new EtiquetaService();
		
		String resultado = etiquetaService.gerarEtiqueta(Categoria.JAZZ);
		
		assertEquals(9,resultado.length());
	}
	
	@Test
	public void deveSerAlphaNumerico() {
		EtiquetaService etiquetaService = new EtiquetaService();
		
		String resultado = etiquetaService.gerarEtiqueta(Categoria.ROCK);
		
		assertTrue(resultado.matches("^[A-Za-z0-9]+$"));
	}
	
	@Test
	public void primeiroCaracterDeveSerUmNumero() {
EtiquetaService etiquetaService = new EtiquetaService();
		
		String resultado = etiquetaService.gerarEtiqueta(Categoria.CLASSICO);
		
		assertTrue(resultado.startsWith("C"));
		
		String resultado2 = etiquetaService.gerarEtiqueta(Categoria.ROCK);
		
		assertFalse(resultado2.startsWith("C"));
	}
}
