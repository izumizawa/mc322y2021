package com.unicamp.mc322.lab13.structure;

public class CrazyDSException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public CrazyDSException() {
		super();
	}

	public CrazyDSException(String s) {
		super(s);
	}

	public CrazyDSException(Throwable cause) {
		super(cause);
	}

	public CrazyDSException(String message, Throwable cause) {
		super(message, cause);
	}

}
