@unitarios
Feature: Alugar Filme
	Como um usuário
	Eu quero cadastrar aluguéis de filmes
	Para controlar preços e datas de entrega

 Scenario: Deve alugar um filme com sucesso
 	Given um filme
 	 | estoque |   2   |
 	 |  preco  |   3   |
 	 |  tipo   | comum |
 	When alugar
 	Then o preco do aluguel sera R$ 3
 	And a data de entrega sera em 1 dia
 	And o estoque do filme sera 1 unidade
 	
 Scenario: Nao deve alugar  filme sem estoque
 	Given um filme com estoque de 0 unidades
 	When alugar
 	Then nao sera possivel por falta de estoque
 	And o estoque do filme sera 0 unidade
 	
 	
 	Scenario Outline: Deve dar condicoes conforme tipo de aluguel
 	 	Given um filme com estoque de 2 unidades
 	 	And que o preco do aluguel seja R$ <preco>
 	 	And que o tipo do aluguel seja <tipo>
 	 	When alugar
 	 	Then o preco do aluguel sera R$ <valor>
 	 	And a data de entrega sera em <qtdDias> dias
 	 	And a pontuacao sera <pontuacao> pontos
		And novo teste
 	
 	Examples: 	
 	 	| preco |     tipo   |  valor | qtdDias | pontuacao |
 	 	|   4   |  extendido |    8   |    3    |     2     |
 	  |   4   |    comum   |    4   |    1    |     1     |  
 	  |   5   |   semanal  |   15   |    7    |     3     | 
 	 	