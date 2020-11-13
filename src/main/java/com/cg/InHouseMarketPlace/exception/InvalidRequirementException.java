package com.cg.InHouseMarketPlace.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidRequirementException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public InvalidRequirementException() {
		super();
	}
	public InvalidRequirementException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidRequirementException(String message) {
		super(message);
	}

	public InvalidRequirementException(Throwable cause) {
		super(cause);
	}
}
