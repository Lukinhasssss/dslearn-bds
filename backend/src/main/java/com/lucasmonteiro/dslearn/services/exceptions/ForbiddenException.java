package com.lucasmonteiro.dslearn.services.exceptions;

public class ForbiddenException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ForbiddenException(String msg) {
		super(msg); // Desta forma eu consigo repassar o argumento para o construtor da superclasse
	}

}