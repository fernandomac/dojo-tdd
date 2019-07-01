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
	private RemoteClient client;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		service = new MainService(client);
	}
	
	@Test
	public void shouldBeInvalid() {
		Integer fator = 2;
		Double valor = -500d;
		
		when(client.getIndice()).thenReturn(2);
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.INVALIDO, actual);
		verify(client).getIndice();
		verifyNoMoreInteractions(client);
		
	}
	
	@Test
	public void shouldBeValid() {
		Integer fator = 2;
		Double valor = 1000d;
		
		when(client.getIndice()).thenReturn(2);
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.VALIDO, actual);
		
	}
	
	@Test
	public void shouldntBeValid() {
		Integer fator = 2;
		Double valor = 5000d;
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertNotEquals(ResultadoValidacao.VALIDO, actual);
		
	}
	
	@Test
	public void shouldBeExtraMiddle() {
		Integer fator = 2;
		Double valor = 5000d;
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.EXTRA, actual);
		
	}
	
	@Test
	public void shouldBeExtraLeft() {
		Integer fator = 2;
		Double valor = 1001d;
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.EXTRA, actual);
	}
	
	@Test
	public void shouldBeExtraRight() {
		Integer fator = 2;
		Double valor = 5000d;
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.EXTRA, actual);
	}
	
	@Test
	public void shouldBeBonusLeft() {
		Integer fator = 2;
		Double valor = 5001d;
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.BONUS, actual);
	}
	
	@Test
	public void shouldBeBonusMiddle() {
		Integer fator = 2;
		Double valor = 10000d;
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.BONUS, actual);
	}
	@Test
	public void shouldBeZero() {
		Integer fator = 0;
		Double valor = 9000d;
		
		ResultadoValidacao actual = service.calculo(fator, valor);
		
		assertEquals(ResultadoValidacao.EXTRA, actual);
	}
}
