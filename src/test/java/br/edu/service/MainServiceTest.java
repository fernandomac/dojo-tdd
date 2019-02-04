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
	public void shouldReturnInvalidIfNegative() {
		Integer fator = -1;
		Double valor = 100.0;

		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.INVALIDO, actual);
	}
	
	@Test
	public void shouldReturnValidIfUpToOneThousand() {
		Integer fator = 1;
		Double valor = 100.0;

		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.VALIDO, actual);
	}
	
	@Test
	public void shouldReturnValidIfIsZero() {
		Integer fator = 0;
		Double valor = 100.0;

		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.VALIDO, actual);
	}

	@Test
	public void shouldReturnValidIfIsThousand() {
		Integer fator = 20;
		Double valor = 100.0;

		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.VALIDO, actual);
	}
	
	@Test
	public void shouldReturnExtraIfFatorIs30AndValor100() {
		Integer fator = 30;
		Double valor = 100.0;

		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.EXTRA, actual);
	}
	
	@Test
	public void shouldReturnBonusIfGreaterThan5000() {
		Integer fator = 230;
		Double valor = 100.0;

		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.BONUS, actual);
	}
	
	@Test
	public void shouldReturnExtraIfFactorIs1AndValorIs2002() {
		Integer fator = 1;
		Double valor = 2002.0;

		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.EXTRA, actual);
	}
	
	@Test
	public void shouldReturnExtraIfFactorIs1AndValorIs10000() {
		Integer fator = 1;
		Double valor = 10000.0;

		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.EXTRA, actual);
	}
	
	@Test
	public void shouldReturnBonusIfFactorIs1AndValorIs10002() {
		Integer fator = 1;
		Double valor = 10002.0;

		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.BONUS, actual);
	}

	@Test
	public void shouldDivideBy3IfFatorIs0() {
		Integer fator = 0;
		Double valor = 300000.0;

		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.BONUS, actual);
	}

}
