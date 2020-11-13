package com.cg.InHouseMarketPlace.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidOfferException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidOfferException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidOfferException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidOfferException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidOfferException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
