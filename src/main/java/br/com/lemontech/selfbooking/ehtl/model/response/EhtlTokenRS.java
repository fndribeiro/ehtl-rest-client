package br.com.lemontech.selfbooking.ehtl.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EhtlTokenRS {

	@JsonProperty("access_token")
	private String accessToken;
	
	@JsonProperty("token_type")
	private String tokenType;
	
	@JsonProperty("expires_in")
	private String expiresIn;
	
	@JsonProperty("refresh_token")
	private String refreshToken;

	public EhtlTokenRS() {
	}

	public EhtlTokenRS(String accessToken, String tokenType, String expiresIn, String refreshToken) {
		this.accessToken = accessToken;
		this.tokenType = tokenType;
		this.expiresIn = expiresIn;
		this.refreshToken = refreshToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public String getExpiresIn() {
		return expiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}
	
	@Override
	public String toString() {
		return "Token: " + this.accessToken;
	}	
}
