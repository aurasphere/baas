package co.aurasphere.baas.languages;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedCaseInsensitiveMap;

@Component("sh")
public class UnixShellExceptionProvider implements LanguageExceptionProvider {

	private LinkedCaseInsensitiveMap<String> exceptionMessageMap = new LinkedCaseInsensitiveMap<>();

	public UnixShellExceptionProvider() {
		exceptionMessageMap.put("bad interpreter", "/bin/sh^M: bad interpreter: No such file or directory");
		exceptionMessageMap.put("missing ]", "[: missing ]");
		exceptionMessageMap.put("syntax error", "Syntax error: end of file unexpected");
		exceptionMessageMap.put("illegal number", "[: Illegal number: xyz");
	}

	@Override
	public LinkedCaseInsensitiveMap<String> getExceptionMessageMap() {
		return exceptionMessageMap;
	}

	@Override
	public String getStacktrace() {
		return "";
	}

}
