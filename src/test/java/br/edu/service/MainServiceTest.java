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
	private RemoteClient remote;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		service = new MainService(remote);
	}
	
	@Test
	public void shouldReturnInvalid() {
		Integer fator = -1;
		Double valor = 150.0;

		when(remote.getRemoteIndex()).thenReturn(2);
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.INVALIDO, actual);
		
	}
	
	@Test
	public void shouldReturnValid() {
		Integer fator = 1;
		Double valor = 150.0;

		when(remote.getRemoteIndex()).thenReturn(2);
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.VALIDO, actual);
	}
	
	@Test
	public void shouldReturnValidWith1000() {
		Integer fator = 1;
		Double valor = 2000.0;

		when(remote.getRemoteIndex()).thenReturn(2);
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.VALIDO, actual);
	}
	
	@Test
	public void shouldReturnExtra() {
		Integer fator = 1;
		Double valor = 3000.0;

		when(remote.getRemoteIndex()).thenReturn(2);
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.EXTRA, actual);
	}
	
	@Test
	public void shouldReturnExtraWith5000() {
		Integer fator = 1;
		Double valor = 10000.0;

		when(remote.getRemoteIndex()).thenReturn(2);
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.EXTRA, actual);
		
	}
	
	@Test
	public void shouldReturnBonus() {
		Integer fator = 1;
		Double valor = 12000.0;

		when(remote.getRemoteIndex()).thenReturn(2);
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.BONUS, actual);
	}
	
	@Test
	public void shouldReturnDividedBy3() {
		Integer fator = 0;
		Double valor = 15000.0;
		when(remote.getRemoteIndex()).thenReturn(3);
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.EXTRA, actual);
	}
	
	@Test
	public void shouldReturnFatorVezesValor() {
		Integer fator = 0;
		Double valor = 15000.0;

		when(remote.getRemoteIndex()).thenReturn(3);
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.EXTRA, actual);
		
		verify(remote).getRemoteIndex();
		verifyNoMoreInteractions(remote);
	}
}
