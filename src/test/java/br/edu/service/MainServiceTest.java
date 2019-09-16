package br.edu.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.edu.domain.ResultadoValidacao;

public class MainServiceTest {
	
	private MainService service;
	
	@Before
	public void setUp() {
		service = new MainService();
	}
	
	@Test
	public void shouldBeInvalid() {
		Integer fator = 1;
		Double valor = -1.0;

		ResultadoValidacao actual = service.calculo(fator, valor);

		assertEquals(ResultadoValidacao.INVALIDO, actual);
		
	}
	
}
