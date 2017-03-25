package app.web.mu.api.business.service.exception.handler;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import app.web.mu.api.business.model.Erro;
import app.web.mu.api.business.service.exception.MarkerExistenteException;
import app.web.mu.api.business.service.exception.MarkerNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@Autowired
    private MessageSource message;
	
	private Locale locale = LocaleContextHolder.getLocale();
	
	@ExceptionHandler(MarkerNaoEncontradoException.class)
	public ResponseEntity<Erro> handleMarkerNaoEncontradoException(MarkerNaoEncontradoException e, HttpServletRequest request) {
		
		
		
		Erro erro = new Erro(message.getMessage("app.web.mu.api.business.service.exception.MarkerNaoEncontradoException.message", null, locale), 
							  404l, System.currentTimeMillis(), "/MapaUniversitarioAPI/404");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(MarkerExistenteException.class)
	public ResponseEntity<Erro> handleMarkerExistenteException(MarkerExistenteException e, HttpServletRequest request) {
		
		Erro erro = new Erro(message.getMessage("app.web.mu.api.business.service.exception.MarkerExistenteException.message", null, locale), 
							 409l, System.currentTimeMillis(), "/MapaUniversitarioAPI/409");
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Erro> handleDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request) {
		
		Erro erro = new Erro(message.getMessage("org.springframework.dao.DataIntegrityViolationException.message", null, locale), 
				             400l, System.currentTimeMillis(), "/MapaUniversitarioAPI/400");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<Erro> handleHttpClientErrorException(HttpClientErrorException e, HttpServletRequest request) {
		Erro erro = new Erro(message.getMessage("org.springframework.web.client.HttpClientErrorException.message", null, locale), 
	             404l, System.currentTimeMillis(), "/MapaUniversitarioAPI/404");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}
