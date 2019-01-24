package br.edu.service;

import br.edu.client.RemoteClient;
import br.edu.domain.ResultadoValidacao;

public class MainService {
	
	private RemoteClient remoteClient;
	
	public MainService(RemoteClient remoteClient) {
		this.remoteClient = remoteClient;
	}

	public ResultadoValidacao calculo (Integer fator, Double valor) {
		ResultadoValidacao result = null;
		double resultadoCalculo;
		
		Integer indice = getIndice(fator);
		
		if (fator == 0) {
			resultadoCalculo = formulaSemFator(valor, indice);
		} else {
			resultadoCalculo = formulaFator(fator, valor, indice);
		}
				
		
		if (resultadoCalculo < 0) {
			result = ResultadoValidacao.INVALIDO;
		} else if (resultadoCalculo < 1001) {
			result = ResultadoValidacao.VALIDO;
		} else if (resultadoCalculo < 5001) {
			result = ResultadoValidacao.BONUS;
		} else {
			result = ResultadoValidacao.EXTRA;
		}
		
		return result;
		
		
	}

	private double formulaSemFator(Double valor, Integer indice) {
		if (indice > 0) {
			return valor / indice;
		} else {
			return valor;
		}
		
	}

	private double formulaFator(Integer fator, Double valor, Integer indice) {
		if (indice > 0) {
			return (fator * valor) / indice;
		} else {
			return (fator * valor);
		}
	}
	
	private Integer getIndice(Integer fator) {
		Integer indice = remoteClient.getRemoteIndice();
		
		if (indice < 0) {
			if (fator == 0) {
				indice = 3;
			} else {
				indice = 2;
			}
		}
		
		return indice;
	}
	
}
