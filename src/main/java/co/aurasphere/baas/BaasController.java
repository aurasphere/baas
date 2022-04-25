package co.aurasphere.baas;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import co.aurasphere.baas.languages.LanguageExceptionProvider;

@RestController
@RequestMapping("/exceptions")
public class BaasController {

	@Autowired
	private Map<String, LanguageExceptionProvider> providers;

	@GetMapping
	public Collection<String> getSupportedLanguages() {
		return providers.keySet();
	}

	@GetMapping("/{language}")
	public Collection<String> getSupportedExceptions(@PathVariable String language) {
		LanguageExceptionProvider languageExceptionProvider = Optional.ofNullable(providers.get(language.toLowerCase()))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Language '" + language + "' is not supported"));
		return languageExceptionProvider.getAvailableExceptions();
	}

	@GetMapping("/{language}/{exception}")
	public BaasResponse throwException(@PathVariable String language, @PathVariable("exception") String exceptionName) {
		LanguageExceptionProvider languageExceptionProvider = Optional.ofNullable(providers.get(language.toLowerCase()))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Language '" + language + "' is not supported"));
		return languageExceptionProvider.getExceptionByName(exceptionName)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Exception '" + exceptionName + "' for language '" + language + "' is not supported"));
	}

}