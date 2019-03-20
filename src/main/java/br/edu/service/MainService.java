package br.edu.service;

import br.edu.client.RemoteClient;
import br.edu.domain.ResultadoValidacao;

public class MainService {
	
	private RemoteClient remoteCliente;
	
	public MainService(RemoteClient remoteCliente) {
		this.remoteCliente = remoteCliente;
	}

	public ResultadoValidacao calculo (Integer fator, Double valor) {
		double calculo = calculaINdice(fator, valor);
		
		if (calculo < 0) {
			return ResultadoValidacao.INVALIDO;
		} else if(calculo <= 1000) {
			return ResultadoValidacao.VALIDO;
		} else if (calculo >= 1001 && calculo <= 5000) {
			return ResultadoValidacao.EXTRA;
		} else if (calculo > 5001) {
			return ResultadoValidacao.BONUS;
		}
		
	
		return null;
	}

	private double calculaINdice(Integer fator, Double valor) {
		
		Integer indiceApi = remoteCliente.getIndice();
		
		double calculo;
		if (fator == 0) {
			calculo = valor / indiceApi;
		}else { 
			calculo = (fator * valor) / indiceApi;
		}
		return calculo;
	}

	
}
