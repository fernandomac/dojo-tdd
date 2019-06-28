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
	
	private MainService service;
	
	@Mock
	private RemoteClient client;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		service = new MainService(client);
	}
	
	@Test
	public void shouldBeInvalid() {
		Integer fator = 12;
		Double valor = -1.0;
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		
		assertEquals(ResultadoValidacao.INVALIDO, actual);
		
	}
	
	@Test(expected=RuntimeException.class)
	public void shouldBeValid() {
		Integer fator = 2;
		Double valor = 1000d;
		
		
		
		when(client.getIndice()).thenThrow(new RuntimeException());
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.VALIDO, actual);
		
		verify(client).getIndice();
		verifyNoMoreInteractions(client);
		
	}

	@Test
	public void shouldBeExtra() {
		Integer fator = 2;
		Double valor = 1001d;
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.EXTRA, actual);
		
	}
	
	@Test
	public void shouldBeBonus() {
		Integer fator = 2;
		Double valor = 5001d;
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.BONUS, actual);
		
	}
	
	@Test
	public void shouldBeValidoMenor1000WithFatorZero() {
		Integer fator = 0;
		Double valor = 299d;
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.VALIDO, actual);
		
	}
	
	
}
