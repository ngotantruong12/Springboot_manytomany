package com.example.NTT.manytomany.exceptions;

public class NotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	public NotFoundException (String exception) {
//		super(exception);
//	}
	
	public NotFoundException(String exception) {
		super(exception);
	}
}
