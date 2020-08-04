package br.com.lemontech.selfbooking.ehtl.service;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.lemontech.selfbooking.ehtl.client.EHTLClient;
import br.com.lemontech.selfbooking.ehtl.client.EHTLLogin;
import br.com.lemontech.selfbooking.ehtl.client.EHTLUri;
import br.com.lemontech.selfbooking.ehtl.model.response.EHTLTokenRS;
import reactor.core.publisher.Mono;

@Service
public class EHTLTokenService {
	
	private EHTLClient client = new EHTLClient();	
	private EHTLLogin login = new EHTLLogin();
	
	public EHTLTokenRS getToken(String username,  String password) throws JsonMappingException, JsonProcessingException {
		
		login.setUsername(username);
		login.setPassword(password);
		
		RequestHeadersSpec<?> request = client.getWebClient().method(HttpMethod.POST).uri(EHTLUri.accessToken).bodyValue(login);
		
		Mono<String> response = client.getResponse(request);
		
		ObjectMapper mapper = new ObjectMapper();
		
		EHTLTokenRS token = mapper.readValue(response.block(), EHTLTokenRS.class);
		
		return token;		
	}
}
