package br.ce.wcaquino.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InserirContasSteps {
	
	private WebDriver driver;

	@Given("^que estou acessando a aplicacao$")
	public void que_estou_acessando_a_aplicacao() throws Throwable {
		driver =  new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me/");
	}

	@When("^informo o usuario \"([^\"]*)\"$")
	public void informo_o_usuario(String email) throws Throwable {
		driver.findElement(By.id("email")).sendKeys(email);
	}

	@When("^a senha \"([^\"]*)\"$")
	public void a_senha(String senha) throws Throwable {
		driver.findElement(By.id("senha")).sendKeys(senha);
	}

	@When("^seleciono entrar$")
	public void seleciono_entrar() throws Throwable {
		driver.findElement(By.tagName("button")).click();
	}

	@Then("^visualizo a pagina inicial$")
	public void visualizo_a_pagina_inicial() throws Throwable {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Assert.assertEquals("Bem vindo, Vinicius Grillo!", texto);
	}
	
	@When("^seleciono Contas$")
	public void seleciono_contas() throws Throwable {
		driver.findElement(By.linkText("Contas")).click();
	}
	
	@When("^seleciono Adicionar$")
	public void seleciono_adicionar() throws Throwable {
		driver.findElement(By.linkText("Adicionar")).click();
	}

	@When("^informo a conta \"([^\\\"]*)\"$")
	public void informo_a_conta(String arg1) throws Throwable {
		driver.findElement(By.id("nome")).sendKeys(arg1);
	}
	
	@When("^seleciono Salvar$")
	public void seleciono_salvar() throws Throwable {
		driver.findElement(By.tagName("button")).click();
	}
	
	@Then("^a conta eh inserida com sucesso$")
	public void a_conta_eh_inserida_com_sucesso() throws Throwable {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Assert.assertEquals("Conta adicionada com sucesso!", texto);
	}
	
	@Then("^sou notificado que o nome da conta eh obrigatorio$")
	public void sou_notificado_que_o_nome_da_conta_eh_obrigatorio() throws Throwable {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		Assert.assertEquals("Informe o nome da conta", texto);
	}
	
	@Then("^sou notificado que ja existe uma conta com esse nome$")
	public void sou_notificado_que_ja_existe_uma_conta_com_esse_nome() throws Throwable {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		Assert.assertEquals("Já existe uma conta com esse nome!", texto);
	}
	
	@Then("^recebo a mensagem \"([^\\\"]*)\"$")
	public void recebo_a_mensagem(String arg1) throws Throwable {
		String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]")).getText();
		Assert.assertEquals(arg1, texto);
	}
		
	@After(order = 1, value = ("@funcionais"))
	public void screeshot(Scenario cenario) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File ("target/screenshot/"+ cenario.getId() +".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After(order = 0, value = ("@funcionais"))
	public void fecharBrowser() {
		driver.quit();	
	}
}
