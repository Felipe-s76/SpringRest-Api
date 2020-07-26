package com.algaworks.osworks.api.exceptionHandler;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.algaworks.osworks.domain.exception.NegocioException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler
	public ResponseEntity<Object> handleNegocio(NegocioException ex, WebRequest request) {
		var status = HttpStatus.BAD_REQUEST;
		
		var problema = new ExceptionFormat();
		problema.setStatus(status.value());
		problema.setMsg(ex.getMessage());
		problema.setDate(OffsetDateTime.now());
		
		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
			var expt = new ExceptionFormat();
			
			var field = new ArrayList<ExceptionFormat.Field>();
			
			for(ObjectError error: ex.getBindingResult().getAllErrors()) {
				String name = ((FieldError) error).getField();
				String msg = messageSource.getMessage(error, LocaleContextHolder.getLocale());
				
				field.add(new ExceptionFormat.Field(name,msg));
			}
			expt.setStatus(status.value());
			expt.setMsg("Um ou mais campos foram preenchidos incorretamente, tente novamente.");
			expt.setDate(OffsetDateTime.now());
			expt.setField(field);
		
		return super.handleExceptionInternal(ex, expt, headers, status, request);
	}
}
