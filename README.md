# DOJO TDD

Esse exercício tem como objetivo simular um desenvolvimento incremental de uma aplicação seguinto a metodologia Ágil e utilizando técnicas de TDD

O PO irá solicitar implementações de negócio de forma incremental ao longo da linha do tempo, aqui representados pelas Sprints.


## Story Sprint 1

	PO solicitou um sistema de validacao de financiamentos que será integrado ao sistema atual que gerenciar os contratos onde:
		1 - O sistema atual informará o VALOR solicitado pelo cliente e um FATOR de credibilidade do mesmo cliente.
		2 - O novo sistema deverá calcular e retornar uma das 4 opções: VALIDO, INVALIDO, EXTRA, BONUS.
		3 - De acordo com a formula: (fator * valor) / 2
		4 - Seguindo a regra de acordo com o resultado da formula: [negativos = INVALIDO], [Até 1000 = VALIDO], [Entre 1001 e 5000 = EXTRA], [Maior 5001 = BONUS]   

## Story Sprint 2

	Ao realizarem a primeira integracao perceberam que o fator pode ser 0 <ZERO> em alguns casos, sendo necessario alterar a regra:
		1 - Caso fator=0 <ZERO> o mesmo deverá ser desconsiderado e o valor deve ser dividido por 3, ficando a formula: (valor / 3)

## Story Sprint 3
	
	Outra equipe da empresa desenvolveu uma sistema que fornece um indice mais preciso para efetuar o calculo da validacao.
		1 - Antes de efutar o calculo, consultar uma API que proverá o indice da divisão, formula (fator * valor) / indiceApi
			URL API: https://us-central1-fernando-machado.cloudfunctions.net/indice-validacao
			Estrutura Retorno: {"indice":2}
			
		2 - Caso a API retorne algum erro utilizar os mesmo indices atuais fixos (fator>0 : 2, fator=0 : 3)
		3 - Caso a API retorne o indice 0 <ZERO> a divisao não deve ser efetuada formula: (fator * valor)
	
