package br.com.ribeiro.fernando.ehtl;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration.WebFluxConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.lemontech.selfbooking.ehtl.client.EHTLClient;
import br.com.lemontech.selfbooking.ehtl.client.EHTLLogin;
import br.com.lemontech.selfbooking.ehtl.client.EHTLUri;
import br.com.lemontech.selfbooking.ehtl.model.request.EHTLDataRQ;
import br.com.lemontech.selfbooking.ehtl.model.request.EHTLHotelAvailRQ;
import br.com.lemontech.selfbooking.ehtl.model.request.EHTLRQ;
import br.com.lemontech.selfbooking.ehtl.model.response.EHTLTokenRS;
import br.com.lemontech.selfbooking.ehtl.service.EHTLTokenService;
import reactor.core.publisher.Mono;

@SpringBootTest
@WebAppConfiguration
@ContextConfiguration(classes = WebFluxConfig.class)
class EhtlApplicationTests {

	private final Logger log = LoggerFactory.getLogger(EhtlApplicationTests.class);
	
	@Test
	void conexao() {

		EHTLClient client = new EHTLClient();
		EHTLLogin login = new EHTLLogin();

		login.setUsername("85213");
		login.setPassword("agenciaws@050539464720802020");

		RequestHeadersSpec<?> request = client.getWebClient().method(HttpMethod.POST).uri(EHTLUri.accessToken).bodyValue(login);
		ResponseEntity<String> response = request.retrieve().toEntity(String.class).block();
		
		Assert.isTrue(response.getStatusCode() == HttpStatus.OK,
				"Status não pode ser diferente de 200." + " Status: " + response.getStatusCode());
	}
	
	@Test
	void erroConexao() throws JsonMappingException, JsonProcessingException {

		EHTLClient client = new EHTLClient();
		EHTLLogin login = new EHTLLogin();
		
		login.setUsername("85214");
		login.setPassword("agenciaws@050539464720802020");
		
		RequestHeadersSpec<?> request = client.getWebClient().method(HttpMethod.POST).uri(EHTLUri.accessToken).bodyValue(login);		
		Mono<String> response = client.getResponse(request);		
		String bodyResponse = response.block();
		
		Assert.isTrue(bodyResponse.contains("errors"), "Retorno deve conter errors.");
	}

	@Test
	void tokenService() throws JsonMappingException, JsonProcessingException {

		EHTLTokenService tokenService = new EHTLTokenService();
		EHTLTokenRS token = tokenService.getToken("85213", "agenciaws@050539464720802020");
		
		Assert.notNull(token, "Classe não pode ser null.");
		Assert.notNull(token.getAccessToken(), "Token não pode ser null.");
	}
	
	@Test
	void disponibilidadeStatus200() throws JsonMappingException, JsonProcessingException {
		
		EHTLTokenService tokenService = new EHTLTokenService();
		EHTLHotelAvailRQ disp = new EHTLHotelAvailRQ();
		EHTLClient client = new EHTLClient();
		
		disp.setDestinationId("Y2l0eS0yMDY");
		disp.setCheckin(2020, 10, 10);
		disp.setNights(1);
		disp.setRoomsAmount(1);
		disp.setRooms(1);
		
		EHTLDataRQ data = new EHTLDataRQ(disp);
		
		EHTLRQ bodyRequest = new EHTLRQ(data);
		
		EHTLTokenRS token = tokenService.getToken("85213", "agenciaws@050539464720802020");		
				
		RequestBodySpec montaRequest = client.getLoggerWebClient().method(HttpMethod.POST).uri(EHTLUri.hotelAvailabilities);
		
		RequestHeadersSpec<?> request = client.setTokenRequest(montaRequest, token).bodyValue(bodyRequest);
		
		Mono<String> response = client.getResponse(request);
		response.block();
	}

	
}