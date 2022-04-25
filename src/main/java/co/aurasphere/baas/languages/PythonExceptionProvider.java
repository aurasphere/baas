package co.aurasphere.baas.languages;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedCaseInsensitiveMap;

@Component("python")
public class PythonExceptionProvider implements LanguageExceptionProvider {

	private static final String STACKTRACE = 
			"Traceback (most recent call last):\n" + 
			"  File \"<stdin>\", line 2, in <module>\n" + 
			"  File \"<stdin>\", line 2, in do_something_that_might_error\n" + 
			"  File \"<stdin>\", line 2, in raise_error";

	private LinkedCaseInsensitiveMap<String> exceptionMessageMap = new LinkedCaseInsensitiveMap<>();

	public PythonExceptionProvider() {
		exceptionMessageMap.put("SyntaxError", "Missing parentheses in call to 'print'. Did you mean print(\"hello\")?");
		exceptionMessageMap.put("IndexError", "list index out of range");
		exceptionMessageMap.put("ModuleNotFoundError", "No module named 'gomorrasql'");
		exceptionMessageMap.put("KeyError", "'4'");
		exceptionMessageMap.put("ImportError", "cannot import name 'cube'");
		exceptionMessageMap.put("StopIteration", "");
		exceptionMessageMap.put("TypeError", "must be str, not int");
		exceptionMessageMap.put("ValueError", "invalid literal for int() with base 10: 'xyz'");
		exceptionMessageMap.put("NameError", "name 'age' is not defined");
		exceptionMessageMap.put("ZeroDivisionError", "division by zero");
		exceptionMessageMap.put("KeyboardInterrupt", "");
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