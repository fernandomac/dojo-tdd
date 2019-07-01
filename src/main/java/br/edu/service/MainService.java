package br.edu.service;

import br.edu.client.RemoteClient;
import br.edu.domain.ResultadoValidacao;

public class MainService {

	private RemoteClient client;
	
	public MainService( RemoteClient client) {
		this.client = client;;
	}

	public ResultadoValidacao calculo (Integer fator, Double valor) {
		ResultadoValidacao result = null;
		
		int indice = client.getIndice();
		
		double calculo = fator > 0 ? (fator * valor) / indice : valor / indice;
		
		if (calculo < 0) {
			result =  ResultadoValidacao.INVALIDO;
		} else if (calculo <= 1000) {
			result =  ResultadoValidacao.VALIDO;
		} else if (calculo >= 1001 && calculo <= 5000) {
			result = ResultadoValidacao.EXTRA;
		} else if (calculo > 5000) {
			result = ResultadoValidacao.BONUS;
		}
		
		return result;
	}

	
}