package app.web.mu.api.business.service;

import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.web.mu.api.business.model.Marker;
import app.web.mu.api.business.service.exception.MarkerNaoEncontradoException;
import app.web.mu.api.persistence.repository.MarkerRepository;

/**
 * Classe de negócio que lida com as operações no banco de dados para o tipo Marker
 * @author santos.rafaelbs
 *
 */
@Service
public class MarkerService {
	
	@Autowired
	private MarkerRepository repository;
	
	@Autowired
    private MessageSource message;
	
	private Locale locale = LocaleContextHolder.getLocale();
	
	@Transactional(readOnly=true)
	public Collection<Marker> listar() {
		return this.repository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Marker buscar(Long id) {
		Marker marker = repository.findOne(id);
		
		if(marker == null)
			throw new MarkerNaoEncontradoException(message.getMessage("app.web.mu.api.business.service.exception.MarkerNaoEncontradoException.message", null, locale));
		
		return marker;
	}
}
