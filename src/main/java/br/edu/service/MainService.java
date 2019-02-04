package br.edu.service;

import br.edu.domain.ResultadoValidacao;

public class MainService {
	
	public MainService() {}

	public ResultadoValidacao calculo (Integer fator, Double valor) {
		double result;

		result = calculoPrivado(fator, valor);
		
		ResultadoValidacao resultado;
		
		
		resultado = classificacao(result);
		
		return resultado;
	}

	private ResultadoValidacao classificacao(double result) {
		ResultadoValidacao resultado;
		if (result < 0) {
			resultado = ResultadoValidacao.INVALIDO;												 
		} else if (result <= 1000) {
			resultado = ResultadoValidacao.VALIDO;
		} else if (result <=5000) {
			resultado = ResultadoValidacao.EXTRA;
		} else {
			resultado = ResultadoValidacao.BONUS;
		}
		return resultado;
	}

	private double calculoPrivado(Integer fator, Double valor) {
		double result;
		if (fator == 0) {
			result = valor / 3;
		} else {
			result = (fator * valor) / 2;	
		}
		return result;
	}

	
}
