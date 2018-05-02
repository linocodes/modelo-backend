package br.gov.mg.meioambiente.exception;

import br.gov.mg.meioambiente.utils.MensagensErro;

public class NotFoundExceptionIdm extends AppException {

	
	private static final long serialVersionUID = 7631724961503100453L;
	private static final String KEY = "erroNotFound";
	
	public NotFoundExceptionIdm(MensagensErro msg) {
		super(msg);		
	}
	
	public NotFoundExceptionIdm(Object... params) {
		super(new MensagensErro(KEY,params));	
	}
	

}
