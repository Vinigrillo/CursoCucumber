package br.ce.wcaquino.steps;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AprenderCucumberSteps {

	@Given("que que criei o arquivo corretamente")
	public void que_que_criei_o_arquivo_corretamente() throws Throwable {

	}

	@When("^executa-lo$")
	public void executá_lo() throws Throwable {

	}

	@Then("a especificacao deve finalizar com sucesso")
	public void a_especificacao_deve_finalizar_com_sucesso() throws Throwable {

	}

	private int contador = 0;
	
	@Given("que o valor do contador e {int}")
	public void que_o_valor_do_contador(Integer int1) {

		contador = int1;
	}

	@When("eu incrementar em {int}")
	public void eu_incrementar_em(Integer int1) {
		 contador = contador + int1;
	}

	@Then("o valor do contador sera {int}")
	public void o_valor_do_contador_ser(int int1) {
		Assert.assertEquals(int1, contador);
	}
	
	Date entrega = new Date();
	
	@Given("que a entrega eh dia {data}")
	public void que_a_entrega_eh_dia(Date data) {
		entrega = data;
	}

	@When("a entrega atrasar em {int} dias")
	public void a_entrega_atrasar_em_dias(Integer int1) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(entrega);
		cal.add(Calendar.DAY_OF_MONTH, int1);
		entrega = cal.getTime();
	} 

	Date atraso = new Date();
	
	@Then("a entrega sera efetuada em {int}\\/{int}\\/{int}")
	public void a_entrega_sera_efetuada_em(Integer int1, Integer int2, Integer int3) {
		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.DAY_OF_MONTH, int1);
		cal2.set(Calendar.MONTH, int2 - 1);
		cal2.set(Calendar.YEAR, int3);
		atraso = cal2.getTime();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String entregaFormatada = format.format(entrega);
		String atrasoFormatado = format.format(atraso);
		Assert.assertEquals(entregaFormatada, atrasoFormatado);
	}

	
	// Deve criar steps genéricos para estes passos
	
	@Given("^que o ticket( especial)? eh (A.\\d{3})$")
	public void que_o_ticket_eh_af(String tipo,String arg1) {

	}

	@Given("^que o valor da passagem eh R\\$ (\\d+),(\\d{2})$")
	public void que_o_valor_da_passagem_r$(int arg1, int arg2) {

	}

	@Given("^que o nome do passageiro eh \"(.{5,20})\"$")
	public void que_o_nome_do_passageiro(String nome) {

	}

	@Given("^que o telefone do passageiro eh (9\\d{3}-\\d{4})$")
	public void que_o_telefone_do_passageiro(String telefone) {

	}

	@When("criar os steps")
	public void criar_os_steps() {

	}

	@Then("o teste vai funcionar")
	public void o_teste_vai_funcionar() {

	}

}
