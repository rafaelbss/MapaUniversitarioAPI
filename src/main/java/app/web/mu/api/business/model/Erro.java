package app.web.mu.api.business.model;

public class Erro {
	
	private String mensagem;
	
	private Long status;
	
	private Long data;
	
	private String url;
	
	public Erro(String mensagem, Long status, Long data) {
		this.mensagem = mensagem;
		this.status = status;
		this.data = data;
	}
	
	public Erro(String mensagem, Long status, Long data, String url) {
		this(mensagem, status, data);
		
		this.url = url;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getData() {
		return data;
	}

	public void setData(Long data) {
		this.data = data;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return mensagem;
	}
}
