package com.student.management.data.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.student.management.data.responce.ValidationFailure;
import com.student.management.data.responce.ValidationFailureResponse;





public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		BindingResult results = ex.getBindingResult();
		List<ValidationFailureResponse> validationErrors = results.getFieldErrors().stream()
				.map(item -> new ValidationFailureResponse(item.getField(), item.getDefaultMessage()))
				.collect(Collectors.toList());
		return handleExceptionInternal(ex,new ValidationFailure(validationErrors), headers, status, request);
	}
	

}
