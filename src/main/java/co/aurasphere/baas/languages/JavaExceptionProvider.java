package co.aurasphere.baas.languages;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedCaseInsensitiveMap;

@Component("java")
public class JavaExceptionProvider implements LanguageExceptionProvider {

	private static final String STACKTRACE = 
			"at co.aurasphere.baas.languages.JavaExceptionProvider.<init>(JavaExceptionProvider.java:17) ~[classes/:na]\n" + 
			"at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method) ~[na:1.8.0_251]\n" + 
			"at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62) ~[na:1.8.0_251]\n" + 
			"at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45) ~[na:1.8.0_251]\n" + 
			"at java.lang.reflect.Constructor.newInstance(Constructor.java:423) ~[na:1.8.0_251]\n" + 
			"at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:212) ~[spring-beans-5.3.5.jar:5.3.5]\n" + 
			"... 37 common frames omitted";

	private LinkedCaseInsensitiveMap<String> exceptionMessageMap = new LinkedCaseInsensitiveMap<>();

	public JavaExceptionProvider() {
		exceptionMessageMap.put("NullPointerException", "null");
		exceptionMessageMap.put("ArithmeticException", "/ by zero");
		exceptionMessageMap.put("ArrayIndexOutOfBoundsException", "5");
		exceptionMessageMap.put("FileNotFoundException", "script.gsql (The system cannot find the file specified)");
		exceptionMessageMap.put("Error", "Unresolved compilation problems");
	}

	@Override
	public LinkedCaseInsensitiveMap<String> getExceptionMessageMap() {
		return exceptionMessageMap;
	}

	@Override
	public String getStacktrace() {
		return STACKTRACE;
	}
	
	@Override
	public String decorateExceptionName(String exceptionName) {
		return "java.lang." + LanguageExceptionProvider.super.decorateExceptionName(exceptionName);
	}

}