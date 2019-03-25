package br.edu.service;

import br.edu.client.RemoteClient;
import br.edu.domain.ResultadoValidacao;

public class MainService {
	
	private RemoteClient client;
	
	public MainService(RemoteClient client) {
		this.client = client;
	}

	public ResultadoValidacao calculo (Integer fator, Double valor) {
		double result = getIndice(fator, valor);
		
		if(result < 0 ) {
			return ResultadoValidacao.INVALIDO;
		}else if(result < 1000) {
			return ResultadoValidacao.VALIDO;
		}else if(result >= 1001 && result <= 5000) {
			return ResultadoValidacao.EXTRA;
		}else {
			return ResultadoValidacao.BONUS;
		}
		
	}

	private double getIndice(Integer fator, Double valor) {
		Integer indice = client.getIndice();
		
		return fator != 0 ? (fator * valor) / indice : valor / indice;
	}

	
}
