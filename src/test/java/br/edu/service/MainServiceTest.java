package br.edu.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.edu.client.RemoteClient;
import br.edu.domain.ResultadoValidacao;

public class MainServiceTest {
	
	@Mock
	private RemoteClient client;
	
	private MainService service;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		service = new MainService(client);
	}
	
	@Test
	public void shouldBeInvalido() {
		Integer fator = 2;
		Double valor = -30.0;
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.INVALIDO, actual);
	}
	
	@Test
	public void shouldBeValid() {
		Integer fator = 2;
		Double valor = 500.0;
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.VALIDO, actual);
	}
	
	@Test
	public void shouldBeExtra() {
		Integer fator = 2;
		Double valor = 1500.0;
		
		when(client.getIndice()).thenReturn(2);
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.EXTRA, actual);
		verify(client).getIndice();
		verifyNoMoreInteractions(client);
	}
	
	@Test
	public void shouldBeExtraUnderBoundary() {
		Integer fator = 1;
		Double valor = 2002.0;
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.EXTRA, actual);
	}
	
	@Test
	public void shouldBeBonus() {
		Integer fator = 10;
		Double valor = 2002.0;
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.BONUS, actual);
	}
	
	@Test
	public void shouldBeUpperBoundaryBonus() {
		Integer fator = 1;
		Double valor = 10002.0;
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.BONUS, actual);
	}
	
	@Test
	public void shouldBeBonusWhenFatorZero() {
		Integer fator = 0;
		Double valor = 16000.0;
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.BONUS, actual);
	}
	
	@Test
	public void shouldBeExtraWhenFatorZero() {
		Integer fator = 0;
		Double valor = 3*1001.0;
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.EXTRA, actual);
	}
	
	
	
}
