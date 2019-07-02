package br.edu.service;

import javax.activity.InvalidActivityException;
import javax.crypto.BadPaddingException;
import javax.management.RuntimeErrorException;

import br.edu.client.RemoteClient;
import br.edu.domain.ResultadoValidacao;

public class MainService {
	
	private RemoteClient client;
	
	public MainService(RemoteClient client) {
		this.client = client;
	}

	public ResultadoValidacao calculo (Integer fator, Double valor) {
		
		int indice;
		
		try {
			 indice = client.getIndice();
		} catch (Exception e) {
			throw new RuntimeException("teste");
		}
		
		double resultadoCalculo = (fator * valor) / indice;
		
		if (fator == 0)
			resultadoCalculo = (valor) / indice;
		
		ResultadoValidacao result = null;
		
		if ( resultadoCalculo < 0) {
			result = ResultadoValidacao.INVALIDO;
		}else if(resultadoCalculo<=1000){
			result = ResultadoValidacao.VALIDO;
		}else if(resultadoCalculo <= 5000) {
			result = ResultadoValidacao.EXTRA;
		}else {
			result = ResultadoValidacao.BONUS;
		}
		
		return result;
	}

	
}
