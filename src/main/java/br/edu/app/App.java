package br.edu.app;

import br.edu.domain.ResultadoValidacao;
import br.edu.service.MainService;

public class App {
    
	public static void main(String[] args) {
//		Input provido pelo sistema principal
		Integer fator = 2;
		Double valor = 100.0;

				
		System.out.println("Inicializando Aplicação");

		MainService service = new MainService();
				
		ResultadoValidacao resultado = service.calculo(fator, valor);
		
		System.out.println(String.format("Validação Realizada:  Valor=%s, Fator=%s [Resultado=%s] ", valor, fator, resultado));
		
		System.out.println("Finalizando Aplicação");
	}
	
}
