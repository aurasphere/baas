package co.aurasphere.baas;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaasResponse {
	private String exception;
	private String stacktrace;
}
