package br.ce.wcaquino.runners;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.CucumberOptions.SnippetType;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = {"br.ce.wcaquino.steps", "br.ce.wcaquino.config"},
		tags = "@funcionais",
		plugin = {"pretty"},
		monochrome = false,
		snippets = SnippetType.CAMELCASE,
		dryRun = false
		)
public class RunnerFuncionalTest {

	@BeforeClass
	public static void reset() {
		WebDriver driver =  new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me/");
		driver.findElement(By.id("email")).sendKeys("vini_grillo@hotmail.com");
		driver.findElement(By.id("senha")).sendKeys("q2w3e4r5");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
	}
}
