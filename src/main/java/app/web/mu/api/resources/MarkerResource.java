package app.web.mu.api.resources;

import java.net.URI;

import java.util.Collection;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import app.web.mu.api.business.model.Marker;
import app.web.mu.api.business.model.MoradiaMarker;
import app.web.mu.api.business.service.MarkerService;
import app.web.mu.api.business.service.MoradiaMarkerService;

/**
 * Classe responsável por expor todos os métodos da API RESTFul MapaUniversitarioAPI
 * @author santos.rafaelbs
 * @version 1.0.0
 */
@RestController
@RequestMapping("/markers")
public class MarkerResource {
	
	//Variável do tipo MarkerService injetada que realiza ações no banco de dados
	@Autowired
	private MarkerService markerService;
	
	//Variável do tipo MarkerService injetada que realiza ações no banco de dados
	@Autowired
	private MoradiaMarkerService moradiaMarkerService;
	
	//MessageSource usado para internacionalização da API
	@Autowired
	private MessageSource messageSource;
	
	/**
	 * Método usado para incluir o Accept-Language no header para dar suporte a internacionalização
	 * @param locale Objeto do tipo locale (Indica a localização do usuário
	 * @return
	 */
	@RequestMapping("/msg")
	public String msg(@RequestHeader("Accept-Language") Locale locale){
		return messageSource.getMessage("msg",null,locale);
	}

	/**
	 * Método utilizado para retornar uma coleção de objetos do tipo Marker
	 * Padrão de URL RESTFul: /MapaUniversitarioAPI/markers [GET]
	 * @return uma coleção de objetos Marker
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Marker>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(this.markerService.listar());
	}
	
	/**
	 * Método utilizado para retornar um objeto do tipo Marker
	 * Padrão de URL RESTFul: /MapaUniveristarioAPI/markers/{id} [GET]
	 * @param id Parâmetro de pesquisa utilizado para retornar um objeto específico do tipo Marker
	 * @return Retorna o objeto localizado no banco de dados de acordo com o parâmetro passado
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		Marker marker = this.markerService.buscar(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(marker);
	}
	
	/**
	 * Salva um objeto do tipo MoradiaMarker no banco de dados
	 * Padrão de URL RESTFul: /MapaUniversitarioAPI/markers/moradias [POST]
	 * @param marker Representa uma instância da classe MoradiaMarker que será persistido no banco de dados
	 * @return Retorna uma String com a URL de acesso ao novo recurso criado
	 */
	@RequestMapping(value="/moradias", method=RequestMethod.POST)
	public ResponseEntity<Void> salvarMoradias(@Valid @RequestBody MoradiaMarker marker) {
		marker = (MoradiaMarker) this.moradiaMarkerService.salvarMoradia(marker);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(marker.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	/**
	 * Retorna uma coleção de objetos do tipo MoradiaMarker
	 * Padrão de URL RESTFul: /MapaUniversitarioAPI/markers/moradias [GET]
	 * @return Retorna uma coleção de objetos do tipo MoradiaMarker
	 */
	@RequestMapping(value="/moradias" ,method = RequestMethod.GET)
	public ResponseEntity<Collection<Marker>> listarMoradias() {
		
		return ResponseEntity.status(HttpStatus.OK).body(this.markerService.listar());
	}
	
	/**
	 * Método utilizado para retornar um objeto do tipo Marker
	 * Padrão de URL RESTFul: /MapaUniversitarioAPI/markers/moradias/{id} [GET]
	 * @param id Parâmetro de pesquisa utilizado para retornar um objeto específico do tipo Marker
	 * @return Retorna o objeto localizado no banco de dados de acordo com o parâmetro passado
	 */
	@RequestMapping(value="/moradias/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarMoradia(@PathVariable("id") Long id) {
		Marker marker = markerService.buscar(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(marker);
	}
	
	/**
	 * Método utilizado para remover um objeto do tipo MoradiaMarker do banco de dados
	 * Padrão de URL RESTFul: /MapaUniversitarioAPI/markers/moradias/{id} [DELETE]
	 * @param id Parâmetro de pesquisa utilizado para remover um objeto específico do tipo Marker
	 * @return Nenhum retorno no corpo da mensagem
	 */
	@RequestMapping(value="/moradias/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> removerMoradia(@PathVariable("id") Long id) {
		this.moradiaMarkerService.removerMoradia(id);
		
		return ResponseEntity.noContent().build();
	}
	
	/**
	 * Método utilizado para atualizar um objeto do tipo MoradiaMarker do banco de dados
	 * Padrão de URL RESTFul: /MapaUniversitarioAPI/markers/moradias/{id} [PUT]
	 * @param marker Representa uma instância do tipo MoradiaMarker que será atualizado no banco de dados
	 * @param id Parâmetro de pesquisa utilizado para atualizar um objeto específico do tipo Marker
	 * @return
	 */
	@RequestMapping(value="/moradias/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody MoradiaMarker marker, @PathVariable("id") Long id) {
		marker.setId(id);
		this.moradiaMarkerService.atualizarMoradia(marker);
		
		return ResponseEntity.noContent().build();
	}
}
