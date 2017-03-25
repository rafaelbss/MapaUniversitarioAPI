package app.web.mu.api.config;

public enum Keys {
	
	APPLICATION_URL("http://localhost:8080/MapaUniveristario"),
	FACEBOOK_APP_ID("1415576381807826"),
	FACEBOOK_APP_ID_URL("graph.facebook.com.consumer_key"),
	FACEBOOK_APP_SECRET_URL("graph.facebook.com.consumer_secret"),
	FACEBOOK_APP_SECRET("adec76a176bd43c03290bfca164f1f1f"),
	FACEBOOK_PERMISSIONS_URL("graph.facebook.com.custom_permissions"),
	FACEBOOK_PERMISSIONS("public_profile,user_education_history,publish_actions,user_managed_groups");
	
	Keys(String key) {
		this.key = key;
	}
	
	private String key;
	
	public String getValue() {
		return this.key;
	}
}
