@unitarios
Feature: Aprender Cucumber
	Como um aluno
	Eu quero aprender a utilizar Cucumber
	Para que eu possa automatizar critérios de aceitação 

 Scenario: Deve executar especificacao
	Given que que criei o arquivo corretamente
	When executa-lo
	Then a especificacao deve finalizar com sucesso
	
 Scenario: Deve incrementar contador
 	Given que o valor do contador e 123
 	When eu incrementar em 35
 	Then o valor do contador sera 158
 
 
	Scenario: Deve calcular atraso na entrega
 	Given que a entrega eh dia 05/04/2018
 	When a entrega atrasar em 2 dias
 	Then a entrega sera efetuada em 07/04/2018 
 	
 	Scenario: Deve criar steps genericos para estes passos
    Given que o ticket eh AF345
    And que o valor da passagem eh R$ 230,45
    And que o nome do passageiro eh "Fulano da Silva"
    And que o telefone do passageiro eh 9999-9999
    When criar os steps
    Then o teste vai funcionar

	Scenario: Deve reaproveitar os steps 'Dado' do cenario anterior
    Given que o ticket eh AB167
    And que o ticket especial eh AB167
    And que o valor da passagem eh R$ 1120,23
    And que o nome do passageiro eh "Cicrano de Oliveira"
    And que o telefone do passageiro eh 9888-8888


#	Scenario: Given negar todos os steps 'Dado' dos cenarios anteriores
    #Given que o ticket eh CD123
    #And que o ticket eh AG1234
    #And que o valor da passagem eh R$ 1.1345,56
    #And que o nome do passageiro eh "Beltrano Souza Matos de Alcântara Azevedo"
    #And que o telefone do passageiro eh 1234-5678
    #And que o telefone do passageiro eh 999-2223 