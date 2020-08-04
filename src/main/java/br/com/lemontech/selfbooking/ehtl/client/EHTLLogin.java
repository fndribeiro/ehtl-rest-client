package br.com.lemontech.selfbooking.ehtl.client;

public class EHTLLogin {

	private String username;
	private String password;
	
	public EHTLLogin() {
	}
	
	public EHTLLogin(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
