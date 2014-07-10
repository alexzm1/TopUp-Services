package com.topup.services.web.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <b>Exception Handler</b> Handles all the exceptions that aren't handled by
 * other specific exception handlers
 * 
 * @author alexzm1
 *
 */
@ControllerAdvice
public class ExceptionsHandler {

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ErrorInfo handleExceptions(HttpServletRequest req, Exception ex) {
		return new ErrorInfo(req.getRequestURI(), req.getMethod(),
				ex.getMessage());
	}

}