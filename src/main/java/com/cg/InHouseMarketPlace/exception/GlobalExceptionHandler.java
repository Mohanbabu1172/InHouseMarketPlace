package com.cg.InHouseMarketPlace.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(InvalidProposalException.class)
    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> resouceNotFoundException(InvalidProposalException ex, WebRequest request) {
    	ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

	@ExceptionHandler(InvalidEmployeeException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> resouceNotFoundException(InvalidEmployeeException ex, WebRequest request) {
	    ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
	    return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidOfferException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> resouceNotFoundException(InvalidOfferException ex, WebRequest request) {
	    ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
	    return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidRequirementException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> resouceNotFoundException(InvalidRequirementException ex, WebRequest request) {
	    ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
	    return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
	}
  
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> globleExcpetionHandler(Exception ex, WebRequest request) {
        ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
