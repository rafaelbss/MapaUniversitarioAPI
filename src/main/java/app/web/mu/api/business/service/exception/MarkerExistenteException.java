package app.web.mu.api.business.service.exception;

/**
 * Classe de exceção usada quando não encontrar um registro do tipo Marker no banco de dados
 * @author santos.rafaelbs
 * @version 1.0.0
 */
public class MarkerExistenteException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public MarkerExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public MarkerExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
