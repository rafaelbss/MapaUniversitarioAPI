package app.web.mu.api.business.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import app.web.mu.api.business.model.Marker;
import app.web.mu.api.business.service.exception.MarkerNaoEncontradoException;
import app.web.mu.api.persistence.repository.MarkerRepository;

/**
 * Classe de negócio que lida com as operações no banco de dados para o tipo MoradiaMarker
 * @author santos.rafaelbs
 * @version 1.0.0
 */
@Service
public class MoradiaMarkerService {
	
	@Autowired
	private MarkerRepository repository;
	
	@Autowired
	private MarkerService service;
	
	@Autowired
    private MessageSource message;
	
	private Locale locale = LocaleContextHolder.getLocale();
	
	/**
	 * Método utilizado para persistir um objeto do tipo MoradiaMarker no banco de dados
	 * @param marker Instância do tipo MoradiaMarker que será persistido no banco de dados
	 * @return Retorna a URL do novo recurso persistido no banco de dados
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Marker salvarMoradia(Marker marker) {
		marker.setId(null);
		return this.repository.save(marker);
	}
	
	/**
	 * Método utilizado para remover um objeto do tipo MoradiaMarker no banco de dados
	 * @param id Parâmetro usado para pesquisar o objeto para remoção
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void removerMoradia(Long id) {
		try {
				repository.delete(id);
			
		} catch(EmptyResultDataAccessException e) {
			throw new MarkerNaoEncontradoException(message.getMessage("app.web.mu.api.business.service.exception.MarkerNaoEncontradoException.message", null, locale));
		}
	}
	
	/**
	 * Método utilizado para atualizar um objeto do tipo MoradiaMarker no banco de dados
	 * @param marker Instância do tipo MoradiaMarker que será atualizado no banco de dados
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void atualizarMoradia(Marker marker) {
		this.checarMoradiaExistente(marker);

		this.repository.save(marker);
	}
	
	/**
	 * Método usado para pesquisar um objeto do tipo Marker existente no banco de dados
	 * @param marker Instância do tipo Marker que será buscado no banco de dados
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	private void checarMoradiaExistente(Marker marker) {
		this.service.buscar(marker.getId());
	}
}
