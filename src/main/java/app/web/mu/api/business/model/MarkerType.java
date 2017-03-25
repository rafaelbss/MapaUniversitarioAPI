package app.web.mu.api.business.model;

/**
 * Enum que representa um tipo MarkerType
 * @author santos.rafaelbs
 *
 */
public enum MarkerType {
	
	MORADIA("Moradia");
	
	private String type;
	
	MarkerType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
}
