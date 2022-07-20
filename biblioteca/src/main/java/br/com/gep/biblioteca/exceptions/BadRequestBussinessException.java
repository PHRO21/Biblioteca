package br.com.gep.biblioteca.exceptions;

public class BadRequestBussinessException extends BussinessException{

	private static final long serialVersionUID = 1L;

	public BadRequestBussinessException(String message) {
		super(message);
	}

}
