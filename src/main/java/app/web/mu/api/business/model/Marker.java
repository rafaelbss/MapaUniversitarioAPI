package app.web.mu.api.business.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Classe representa uma entidade do tipo Marker no banco de dados
 * @author santos.rafaelbs
 * @version 1.0.0
 */
@Entity
@Table(name="marker")
@Inheritance(strategy=InheritanceType.JOINED)
public class Marker implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_marker")
	@JsonInclude(Include.NON_NULL)
	private Long id;
	
	@Column(name="nome")
	@NotEmpty
	@JsonInclude(Include.NON_NULL)
	private String nome;
	
	@Column(name="latitude")
	@NotNull
	@JsonInclude(Include.NON_NULL)
	private Double latitude;
	
	@Column(name="longitude")
	@NotNull
	@JsonInclude(Include.NON_NULL)
	private Double longitude;
	
	@Column(name="telefone")
	@NotEmpty
	private String telefone;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo")
	@NotNull
	@JsonInclude(Include.NON_NULL)
	private MarkerType tipo;
	
	@Column(name="facebook_user")
	@NotNull
	@JsonInclude(Include.NON_NULL)
	private String facebookUser;
	
	public Marker() {}
	
	public Marker(String nome) {
		this.nome = nome;
	}
	
	public Marker(String nome, Double latitude, Double longitude) {
		this(nome);
		
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Marker(String nome, Double latitude, Double longitude, String telefone) {
		this(nome, latitude, longitude);
		
		this.telefone = telefone;
	}
	
	public Marker(String nome, Double latitude, Double longitude, String telefone, MarkerType tipo) {
		this(nome, latitude, longitude, telefone);
		
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public MarkerType getTipo() {
		return tipo;
	}

	public void setTipo(MarkerType tipo) {
		this.tipo = tipo;
	}

	public String getFacebookUser() {
		return facebookUser;
	}

	public void setFacebookUser(String facebookUser) {
		this.facebookUser = facebookUser;
	}

	@Override
	public String toString() {
		return this.nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Marker))
			return false;
		Marker other = (Marker) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
