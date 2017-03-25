package app.web.mu.api.business.service.exception;

public class MarkerNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public MarkerNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public MarkerNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
