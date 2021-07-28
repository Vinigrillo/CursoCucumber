package br.ce.wcaquino.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.ParseException;
import io.cucumber.cucumberexpressions.ParameterType;

public class RegistryCucumber implements TypeRegistryConfigurer {

	@Override
	public void configureTypeRegistry(TypeRegistry registry) {
		registry.defineParameterType(
				new ParameterType<>("data",".*", Date.class, (String s) -> {
					DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					try {
						Date retorno = format.parse(s);
						return retorno;
					} catch (ParseException e) {
						e.printStackTrace();
						return null;
					}
				})
				);

	}

	@Override
	public Locale locale() {
		return Locale.ENGLISH;

	}
}
