package br.gov.mg.meioambiente.exception;

import br.gov.mg.meioambiente.utils.MensagensErro;

public class AppException extends RuntimeException  {

	private static final long serialVersionUID = -4490060671494243485L;
	
	private MensagensErro msg;

	public AppException(MensagensErro msg) {
		super(msg.getErro());
		this.msg = msg;
	}
	
	public MensagensErro getMensagensErro() {
		return msg;
	}	

	public AppException() {
        super();
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(Throwable cause) {
        super(cause);
    }
    
}
