package br.edu.service;

import br.edu.domain.ResultadoValidacao;

public class MainService {
	
	public MainService() {}

	public ResultadoValidacao calculo (Integer fator, Double valor) {
		ResultadoValidacao result = null;
		double resultadoCalculo;
		
		resultadoCalculo = formulaFator(fator, valor);
				
		
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

	private double formulaFator(Integer fator, Double valor) {
		return (fator * valor) / 2;
	}
	
}
