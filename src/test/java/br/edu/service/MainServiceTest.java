package br.edu.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
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
	private RemoteClient remoteClient;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		service = new MainService(remoteClient);
	}
	
	@Test
	public void shouldBeInvalid() {
		
		Integer fator = -1;
		Double valor = 23.4;
		
		ResultadoValidacao result = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.INVALIDO, result);
		
	}
	
	@Test
	public void shouldNotBeInvalid() {
		
		Integer fator = 1;
		Double valor = 23.4;
		
		ResultadoValidacao result = service.calculo(fator, valor);
		
		assertNotEquals(ResultadoValidacao.INVALIDO, result);
		
	}
	
	@Test
	public void shouldBeValid() {
		
		Integer fator = 50;
		Double valor = 23.4;
		
		ResultadoValidacao result = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.VALIDO, result);
		
	}
	
	@Test
	public void shouldNotBeValid() {
		
		Integer fator = 100;
		Double valor = 23.4;
		
		ResultadoValidacao result = service.calculo(fator, valor);
		
		assertNotEquals(ResultadoValidacao.VALIDO, result);
		
	}
	
	@Test
	public void shouldBeExtra() {
		Integer fator = 10000;
		Double valor = 1.0;
		
		when(remoteClient.getIndice()).thenReturn(2);
		
		ResultadoValidacao result = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.EXTRA, result);
		verify(remoteClient).getIndice();
		verifyNoMoreInteractions(remoteClient);
	}
	
	@Test
	public void shouldNotBeExtra() {
		Integer fator = 10;
		Double valor = 23.4;
		
		ResultadoValidacao result = service.calculo(fator, valor);
		
		assertNotEquals(ResultadoValidacao.EXTRA, result);
	}
	
	@Test
	public void shouldBeBonus() {
		Integer fator = 10004;
		Double valor = 1.0;
		
		ResultadoValidacao result = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.BONUS, result);
	}
	
	@Test
	public void shouldBeExtraWhenZero() {
		Integer fator = 0;
		Double valor = 4000.0;
		
		ResultadoValidacao result = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.EXTRA, result);
	}
}
