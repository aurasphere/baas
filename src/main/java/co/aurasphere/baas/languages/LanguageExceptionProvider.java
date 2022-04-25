package co.aurasphere.baas.languages;

import java.util.Collection;
import java.util.Optional;

import org.springframework.util.LinkedCaseInsensitiveMap;

import co.aurasphere.baas.BaasResponse;

public interface LanguageExceptionProvider {

	LinkedCaseInsensitiveMap<String> getExceptionMessageMap();

	String getStacktrace();

	default Collection<String> getAvailableExceptions() {
		return getExceptionMessageMap().keySet();
	}

	default Optional<BaasResponse> getExceptionByName(String exceptionName) {
		String exceptionMessage = getExceptionMessageMap().get(exceptionName);
		if (exceptionMessage == null) {
			return Optional.empty();
		}
		return Optional.of(new BaasResponse(decorateExceptionName(exceptionName) + exceptionMessage, getStacktrace()));
	}

	default String decorateExceptionName(String exceptionName) {
		// Retrieves the correctly formatted exception name
		return getExceptionMessageMap().keySet().stream().filter(k -> k.equalsIgnoreCase(exceptionName)).findFirst()
				.get() + ": ";
	}

}