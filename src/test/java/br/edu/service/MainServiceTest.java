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
	
	@Test(expected=RuntimeException.class)
	public void shouldBeInvalidIfValorNegativo() {
		Integer fator = 2;
		Double valor = -10d;
		
		when(client.getIndice()).thenThrow(new RuntimeException());
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.INVALIDO, actual);
		verify(client).getIndice();
		verifyNoMoreInteractions(client);
	}
	
	@Test
	public void shouldBeValidIfValorAbaixoMil() {
		Integer fator = 2;
		Double valor = 999d;

		when(client.getIndice()).thenReturn(2);
		
		ResultadoValidacao actual = service.calculo(fator, valor);

		assertEquals(ResultadoValidacao.VALIDO, actual);
	}
	
	@Test
	public void shouldBeValidIfValorEntreMilEUmECincoMil() {
		Integer fator = 2;
		Double valor = 4500d;

		when(client.getIndice()).thenReturn(2);
		
		ResultadoValidacao actual = service.calculo(fator, valor);

		assertEquals(ResultadoValidacao.EXTRA, actual);
	}
	
	@Test
	public void shouldBeValidIfValorMaiorQueCincoMil() {
		Integer fator = 2;
		Double valor = 6000d;

		when(client.getIndice()).thenReturn(2);
		
		ResultadoValidacao actual = service.calculo(fator, valor);

		assertEquals(ResultadoValidacao.BONUS, actual);
	}
	
	@Test
	public void shouldBeValidIfValidaFatorZero() {
		Integer fator = 0;
		Double  valor = 15000d;

		when(client.getIndice()).thenReturn(3);
		
		ResultadoValidacao actual = service.calculo(fator, valor);

		assertEquals(ResultadoValidacao.EXTRA, actual);
	}
	
}
