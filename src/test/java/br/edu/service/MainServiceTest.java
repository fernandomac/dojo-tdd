package br.edu.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.edu.domain.ResultadoValidacao;

public class MainServiceTest {

	private MainService service = new MainService();
	
	@Test
	public void shouldInvalid() {
		
		Integer fator = -10;
		Double valor = 1000.0;
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.INVALIDO, actual);
	}
	
	@Test
	public void shouldValid() {
		
		Integer fator = 1;
		Double valor = 1000.0;
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.VALIDO, actual);
	}
	
	@Test
	public void shouldBonus() {
		
		Integer fator = 3;
		Double valor = 1000.0;
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.BONUS, actual);
	}
	
	@Test
	public void shouldExtra() {
		
		Integer fator = 4;
		Double valor = 10000.0;
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.EXTRA, actual);
	}
	
	@Test
	public void shouldBonusFatorZero() {
		
		Integer fator = 0;
		Double valor = 12000.0;
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.BONUS, actual);
	}
}
