package app.web.mu.api.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import app.web.mu.api.business.model.Marker;
import app.web.mu.api.business.model.MoradiaMarker;
import app.web.mu.api.business.service.exception.MarkerNaoEncontradoException;
import app.web.mu.api.persistence.repository.MarkerRepository;

@Service
public class MoradiaService {
	
	@Autowired
	private MarkerRepository repository;
	
	@Autowired
	private MarkerService service;
	
	public Marker salvarMoradia(MoradiaMarker marker) {
		return this.repository.save(marker);
	}
	
	public void removerMoradia(Long id) {
		try {
				repository.delete(id);
			
		} catch(EmptyResultDataAccessException e) {
			throw new MarkerNaoEncontradoException("Informação não foi encontrada no banco de dados!");
		}
	}
	
	public void atualizarMoradia(MoradiaMarker marker) {
		this.checarMoradiaExistente(marker);
		this.repository.save(marker);
	}
	
	private void checarMoradiaExistente(Marker marker) {
		this.service.buscar(marker.getId());
	}
}
