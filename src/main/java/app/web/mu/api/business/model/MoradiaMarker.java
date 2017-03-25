package app.web.mu.api.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="moradia")
@PrimaryKeyJoinColumn(name="id")
public class MoradiaMarker extends Marker {

	private static final long serialVersionUID = 1L;
	
	@Column(name="detalhes")
	private String detalhes;
	
	@Column(name="observacoes")
	private String observacoes;
	
	public MoradiaMarker() {}
	
	public MoradiaMarker(String nome, Double latitude, Double longitude, String telefone, MarkerType tipo, String detalhes) {
		super(nome, latitude, longitude, telefone, tipo);
		
		this.detalhes = detalhes;
	}
	
	public MoradiaMarker(String nome, Double latitude, Double longitude, String telefone, MarkerType tipo, String detalhes, String observacoes) {
		this(nome, latitude, longitude, telefone, tipo, detalhes);
		
		this.observacoes = observacoes;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
}
