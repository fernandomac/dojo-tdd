package br.edu.service;

import br.edu.domain.ResultadoValidacao;

public class MainService {
	
	public MainService() {}

	public ResultadoValidacao calculo(Integer fator, Double valor) {
		
		double indice = (fator * valor) / 2;
		
		if (indice < 0 ) {
			return ResultadoValidacao.INVALIDO;
		}
		
		return  null;
	}

	
}
