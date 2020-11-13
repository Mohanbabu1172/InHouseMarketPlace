package com.cg.InHouseMarketPlace.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidProposalException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public InvalidProposalException() {
		super();
	}
	public InvalidProposalException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidProposalException(String message) {
		super(message);
	}

	public InvalidProposalException(Throwable cause) {
		super(cause);
	}
}
