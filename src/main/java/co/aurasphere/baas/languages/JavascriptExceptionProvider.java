package co.aurasphere.baas.languages;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedCaseInsensitiveMap;

@Component("javascript")
public class JavascriptExceptionProvider implements LanguageExceptionProvider {

	private static final String STACKTRACE = 
			"at javascriptProvider (<anonymous>:1:39)\n" + 
			"at <anonymous>:1:1";

	private LinkedCaseInsensitiveMap<String> exceptionMessageMap = new LinkedCaseInsensitiveMap<>();

	public JavascriptExceptionProvider() {
		exceptionMessageMap.put("Error", "Permission denied to access property 'x'");
		exceptionMessageMap.put("InternalError", "too much recursion");
		exceptionMessageMap.put("RangeError", "invalid array length");
		exceptionMessageMap.put("ReferenceError", "invalid assignment left-hand side");
		exceptionMessageMap.put("SyntaxError", "Malformed formal parameter");
		exceptionMessageMap.put("TypeError", "More arguments needed");
		exceptionMessageMap.put("URIError", "malformed URI sequence");
	}

	@Override
	public LinkedCaseInsensitiveMap<String> getExceptionMessageMap() {
		return exceptionMessageMap;
	}

	@Override
	public String getStacktrace() {
		return STACKTRACE;
	}

}