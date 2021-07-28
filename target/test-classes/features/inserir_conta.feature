@funcionais
Feature: Cadastro de contas

Como um usuário 
Gostaria de cadastrar contas
Para que eu possa distribuir meu dinheiro de uma forma mais organizada

Background:
Given que estou acessando a aplicacao
When informo o usuario "vini_grillo@hotmail.com"
And a senha "q2w3e4r5"
And seleciono entrar
Then visualizo a pagina inicial
When seleciono Contas
And seleciono Adicionar

Scenario Outline: Deve validar regras cadastro contas
When informo a conta "<conta>"
And seleciono Salvar
Then recebo a mensagem "<mensagem>"

Examples:
 |      conta     |             mensagem              |
 | Conta de Teste |   Conta adicionada com sucesso!   |
 |                |      Informe o nome da conta      |
 #|Conta mesmo nome| Já existe uma conta com esse nome!|
 