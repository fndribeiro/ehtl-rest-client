package br.com.lemontech.selfbooking.ehtl.exception;

public class InvalidTokenException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidTokenException(String erro) {
		super(erro);
	}

}
