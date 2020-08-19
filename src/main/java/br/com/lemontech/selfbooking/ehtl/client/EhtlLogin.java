package br.com.lemontech.selfbooking.ehtl.client;

public class EhtlLogin {

	private final String username;
	private final String password;
	
	public EhtlLogin(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
}
