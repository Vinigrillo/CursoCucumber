package br.ce.wcaquino.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.junit.Assert;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.NotaAluguel;
import br.ce.wcaquino.entidades.TipoAluguel;
import br.ce.wcaquino.servicos.AluguelService;
import br.ce.wcaquino.utils.DateUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlugarFilmeSteps {

	private Filme filme;
	private AluguelService aluguel = new AluguelService();
	private NotaAluguel nota;
	private String erro;
	private TipoAluguel tipoAluguel;

	@Given("^um filme com estoque de (\\d+) unidades$")
	public void um_filme_com_estoque_de_unidades(int arg1) throws Throwable {
		filme = new Filme();
		filme.setEstoque(arg1);
	}
	
	@Given("^que o preco do aluguel seja R\\$ (\\d+)$")
	public void que_o_preco_do_aluguel_seja_r$(int arg1) throws Throwable {
		filme.setAluguel(arg1);
	}
	
	@Given("^um filme$")
	public void um_filme(DataTable table) throws Throwable {
		Map<String, String> map = table.asMap(String.class, String.class);
		filme = new Filme();
		filme.setEstoque(Integer.parseInt(map.get("estoque")));
		filme.setAluguel(Integer.parseInt(map.get("preco")));
		String tipo = map.get("tipo");
		tipoAluguel = tipo.equals("semanal") ? TipoAluguel.SEMANAL
				: tipo.equals("extendido") ? TipoAluguel.EXTENDIDO : TipoAluguel.COMUM;
	} 

	@When("^alugar$")
	public void executá_lo() throws Throwable {
		try {
			nota = aluguel.alugar(filme, tipoAluguel);
		} catch (RuntimeException e) {
			erro = e.getMessage();
		}
	}

	@Then("^o preco do aluguel sera R\\$ (\\d+)$")
	public void o_preco_do_aluguel_sera_r$(int arg1) throws Throwable {
		Assert.assertEquals(arg1, nota.getPreco());
	}

	@Then("^o estoque do filme sera (\\d+) unidade$")
	public void o_estoque_do_filme_sera_unidade(int arg1) throws Throwable {
		Assert.assertEquals(arg1, filme.getEstoque());
	}

	@Then("^nao sera possivel por falta de estoque$")
	public void nao_sera_possivel_por_falta_de_estoque() throws Throwable {
		Assert.assertEquals("Filme sem estoque", erro);
	}

	@Given("^que o tipo do aluguel seja (.*)$")
	public void que_o_tipo_do_aluguel_seja_extendido(String tipo) throws Throwable {
		tipoAluguel = tipo.equals("semanal") ? TipoAluguel.SEMANAL
				: tipo.equals("extendido") ? TipoAluguel.EXTENDIDO : TipoAluguel.COMUM;
	}

	@Then("^a data de entrega sera em (\\d+) dias?$")
	public void a_data_de_entrega_sera_em_dias(int arg1) throws Throwable {
		Date dataEsperada = DateUtils.obterDataDiferencaDias(arg1);
		Date dataReal = nota.getDataEntrega();
		DateFormat format = new SimpleDateFormat("dd/MM;yyyy");

		Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
	}

	@Then("^a pontuacao sera (\\d+) pontos$")
	public void a_pontuacao_sera_de_pontos(int arg1) throws Throwable {
		Assert.assertEquals(arg1, nota.getPontuacao());
	}
	

}
