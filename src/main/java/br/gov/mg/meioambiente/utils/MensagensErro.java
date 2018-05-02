package br.gov.mg.meioambiente.utils;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.springframework.validation.Errors;

public class MensagensErro {

	private String erro;

	public MensagensErro(String key, Object... params) {
		this.erro = MessageFormat.format(getArquivoMensagem().getString(key), params);
	}

	public MensagensErro(String key) {
		this.erro = getArquivoMensagem().getString(key);
	}

	private ResourceBundle getArquivoMensagem() {
		return ResourceBundle.getBundle("mensagem-erro");
	}

	public String getErro() {
		return erro;
	}

	public static String getAtributosInvalidos(Errors errors) {
		String texto = "[{campo}]: {mensagem}";
		return errors.getFieldErrors().stream()
				.map(x -> texto.replace("{campo}", x.getField()).replace("{mensagem}", x.getDefaultMessage()))
				.collect(Collectors.joining(";"));

	}

}
