package br.com.lemontech.selfbooking.ehtl.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.jetty.util.StringUtil;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.lemontech.selfbooking.ehtl.client.EhtlClient;
import br.com.lemontech.selfbooking.ehtl.client.EhtlLogin;
import br.com.lemontech.selfbooking.ehtl.client.EhtlUri;
import br.com.lemontech.selfbooking.ehtl.exception.InvalidTokenException;
import br.com.lemontech.selfbooking.ehtl.model.request.EhtlCompleteBookingProcessRQ;
import br.com.lemontech.selfbooking.ehtl.model.request.EhtlDataRQ;
import br.com.lemontech.selfbooking.ehtl.model.request.EhtlDetailsHotelAvailabilitiesRQ;
import br.com.lemontech.selfbooking.ehtl.model.request.EhtlHotelAvailabilitiesRQ;
import br.com.lemontech.selfbooking.ehtl.model.request.EhtlRQ;
import br.com.lemontech.selfbooking.ehtl.model.response.EhtlRS;
import br.com.lemontech.selfbooking.ehtl.model.response.EhtlTokenRS;
import reactor.core.publisher.Mono;

public class EhtlService {

	private EhtlTokenRS token;
	private EhtlClient client = new EhtlClient();
	
	//instancia a classe e já cria um token.
	public EhtlService(String username, String password) throws JsonMappingException, JsonProcessingException {
		
		EhtlLogin login = new EhtlLogin(username, password);
		
		RequestHeadersSpec<?> request = client.getWebClient().method(HttpMethod.POST).uri(EhtlUri.accessToken)
				.bodyValue(login);
		
		Mono<String> response = client.getResponse(request);
		
		ObjectMapper mapper = new ObjectMapper();
		
		this.token = mapper.readValue(response.block(), EhtlTokenRS.class);
	}
	
	public EhtlTokenRS getToken() throws InvalidTokenException {
		
		validaToken();
		return this.token;
	}

	public EhtlRS getDisponibilidade(String destinationId, Date checkin, int nights, int roomsAmount) 
			throws JsonMappingException, JsonProcessingException, InvalidTokenException {

		validaToken();

		EhtlHotelAvailabilitiesRQ disponibilidadeModel = new EhtlHotelAvailabilitiesRQ();
		disponibilidadeModel.setDestinationId(destinationId);
		disponibilidadeModel.setCheckin(checkin);
		disponibilidadeModel.setNights(nights);
		disponibilidadeModel.setRoomsAmount(roomsAmount);

		EhtlDataRQ data = new EhtlDataRQ(disponibilidadeModel);
		EhtlRQ requestBody = new EhtlRQ(data);

		RequestBodySpec requestBuilder = client.getWebClient().method(HttpMethod.POST).uri(EhtlUri.hotelAvailabilities);
		RequestHeadersSpec<?> request = client.setTokenRequest(requestBuilder, token).bodyValue(requestBody);
		
		Mono<String> response = client.getResponse(request);
		
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.readValue(response.block(), EhtlRS.class);
	}
	
	public EhtlRS getDetalhesDoQuarto(String hotelCode, String roomCode) 
			throws InvalidTokenException, JsonMappingException, JsonProcessingException {
		
		validaToken();
		
		EhtlDetailsHotelAvailabilitiesRQ detalhesDoHotel = new EhtlDetailsHotelAvailabilitiesRQ();
		detalhesDoHotel.setHotelCode(hotelCode);
		detalhesDoHotel.setRoomCode(roomCode);
		
		EhtlDataRQ data = new EhtlDataRQ(detalhesDoHotel);
		EhtlRQ requestBody = new EhtlRQ(data);
		
		RequestBodySpec requestBuilder = client.getWebClient().method(HttpMethod.POST).uri(EhtlUri.detailHotelAvaiabilities);		
		RequestHeadersSpec<?> request = client.setTokenRequest(requestBuilder, token).bodyValue(requestBody);
		
		Mono<String> response = client.getResponse(request);
		
		ObjectMapper mapper = new ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mapper.setDateFormat(dateFormat);
		
		return mapper.readValue(response.block(), EhtlRS.class);
	}
	
	public EhtlRS criaReserva(EhtlCompleteBookingProcessRQ reservaModel) throws InvalidTokenException, JsonMappingException, JsonProcessingException {
		
		validaToken();
		
		EhtlDataRQ data = new EhtlDataRQ(reservaModel);
		EhtlRQ requestBody = new EhtlRQ(data);
		
		RequestBodySpec requestBuilder = client.getWebClient().method(HttpMethod.POST).uri(EhtlUri.completeBookingProcess);		
		RequestHeadersSpec<?> request = client.setTokenRequest(requestBuilder, token).bodyValue(requestBody);
		
		Mono<String> response = client.getResponse(request);
	
		ObjectMapper mapper = new ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		
		return mapper.readValue(response.block(), EhtlRS.class);
	}
	
	public EhtlRS cancelaReserva(String bookingId) throws InvalidTokenException, JsonMappingException, JsonProcessingException {
		
		validaToken();
		
		RequestBodySpec requestBuilder = client.getWebClient().method(HttpMethod.DELETE).uri(EhtlUri.cancelBooking + bookingId);
		RequestHeadersSpec<?> request = client.setTokenRequest(requestBuilder, token);
		
		Mono<String> response = client.getResponse(request);
		
		ObjectMapper mapper = new ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		
		return mapper.readValue(response.block(), EhtlRS.class);
	}
	
	private void validaToken() throws InvalidTokenException {

		if (StringUtil.isEmpty(this.token.getAccessToken())) {
			throw new InvalidTokenException("Token não pode ser null ou vazio.");
		}
	}

}
