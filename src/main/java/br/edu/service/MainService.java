package br.edu.service;

import br.edu.client.RemoteClient;
import br.edu.domain.ResultadoValidacao;

public class MainService {
	
	private final RemoteClient remote;
	
	public MainService(RemoteClient remote) {
		this.remote = remote;
	}

	public ResultadoValidacao calculo (Integer fator, Double valor) {
		
		int remoteIndice = remote.getRemoteIndex();
		
		double calculo = calculoFatorGreaterThanZero(fator, valor, remoteIndice);
		
		if(fator == 0) {
			calculo = calculoFatorZero(valor, remoteIndice);
		} 
		
		if (calculo < 0) {
			return ResultadoValidacao.INVALIDO;
		} else if (calculo <= 1000){
			return ResultadoValidacao.VALIDO;
		}
		else if (calculo <= 5000){
			return ResultadoValidacao.EXTRA;
		} else {
			return ResultadoValidacao.BONUS;
		}
	}

	private double calculoFatorZero(Double valor, int remoteIndice) {
		return valor / remoteIndice;
	}

	private double calculoFatorGreaterThanZero(Integer fator, Double valor, int remoteIndice) {
		return (fator * valor) / remoteIndice;
	}

	
}
