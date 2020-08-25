package br.com.ribeiro.fernando.ehtl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration.WebFluxConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.lemontech.selfbooking.ehtl.client.EhtlClient;
import br.com.lemontech.selfbooking.ehtl.client.EhtlLogin;
import br.com.lemontech.selfbooking.ehtl.client.EhtlUri;
import br.com.lemontech.selfbooking.ehtl.exception.InvalidTokenException;
import br.com.lemontech.selfbooking.ehtl.model.request.EhtlCompleteBookingProcessRQ;
import br.com.lemontech.selfbooking.ehtl.model.request.EhtlPassengerRQ;
import br.com.lemontech.selfbooking.ehtl.model.request.EhtlPaymentTypeRQ;
import br.com.lemontech.selfbooking.ehtl.model.request.EhtlRoomPassengerRQ;
import br.com.lemontech.selfbooking.ehtl.model.response.EhtlBookingRS;
import br.com.lemontech.selfbooking.ehtl.model.response.EhtlCancelBookingRS;
import br.com.lemontech.selfbooking.ehtl.model.response.EhtlDataRS;
import br.com.lemontech.selfbooking.ehtl.model.response.EhtlDetailsHotelAvailabilitiesRS;
import br.com.lemontech.selfbooking.ehtl.model.response.EhtlHotelAvailabilitiesRS;
import br.com.lemontech.selfbooking.ehtl.model.response.EhtlHotelTaxRS;
import br.com.lemontech.selfbooking.ehtl.model.response.EhtlRS;
import br.com.lemontech.selfbooking.ehtl.model.response.EhtlRoomRS;
import br.com.lemontech.selfbooking.ehtl.model.response.EhtlSearchCitiesRS;
import br.com.lemontech.selfbooking.ehtl.model.response.EhtlTokenRS;
import br.com.lemontech.selfbooking.ehtl.service.EhtlService;
import reactor.core.publisher.Mono;

@SpringBootTest
@WebAppConfiguration
@ContextConfiguration(classes = WebFluxConfig.class)
class EhtlApplicationTests {

	@Test
	void conexao() {

		EhtlClient client = new EhtlClient();
		EhtlLogin login = new EhtlLogin("85213", "agenciaws@050539464720802020");

		RequestHeadersSpec<?> request = client.getWebClient().method(HttpMethod.POST).uri(EhtlUri.accessToken)
				.bodyValue(login);
		ResponseEntity<String> response = request.retrieve().toEntity(String.class).block();

		Assert.isTrue(response.getStatusCode() == HttpStatus.OK,
				"Status não pode ser diferente de 200." + " Status: " + response.getStatusCode());
	}

	@Test
	void erroConexao() throws JsonMappingException, JsonProcessingException {

		EhtlClient client = new EhtlClient();
		EhtlLogin login = new EhtlLogin("85214", "agenciaws@050539464720802020");

		RequestHeadersSpec<?> request = client.getWebClient().method(HttpMethod.POST).uri(EhtlUri.accessToken)
				.bodyValue(login);
		Mono<String> response = client.getResponse(request);
		String bodyResponse = response.block();

		Assert.isTrue(bodyResponse.contains("errors"), "Retorno deve conter errors.");
	}

	@Test
	void ehtlService() throws JsonMappingException, JsonProcessingException, InvalidTokenException {

		EhtlService ehtlService = new EhtlService("85213", "agenciaws@050539464720802020");
		EhtlTokenRS token = ehtlService.getToken();

		Assert.notNull(token, "Classe não pode ser null.");
		Assert.notNull(token.getAccessToken(), "Token não pode ser null.");
	}

	@Test
	void disponibilidadeService() throws IOException, InvalidTokenException {

		EhtlService ehtlService = new EhtlService("85213", "agenciaws@050539464720802020");

		Calendar calendar = Calendar.getInstance();
		calendar.set(2020, 10, 10);

		Date checkin = calendar.getTime();

		EhtlRS disponibilidade = ehtlService.getDisponibilidade("Y2l0eS0yMDY", checkin, 2, 1);

		ArrayList<EhtlDataRS> data = disponibilidade.getData();

		Assert.notEmpty(data, "Disponibilidade não pode ser null e deve conter pelo menos um elemento.");

		for (EhtlDataRS attributes : data) {

			EhtlHotelAvailabilitiesRS hotel = (EhtlHotelAvailabilitiesRS) attributes;
			Assert.hasLength(hotel.getId(), "Id não pode ser vazio.");
			Assert.hasLength(hotel.getAttributes().getHotel(), "Hotel não pode ser vazio.");

			ArrayList<EhtlRoomRS> hotelRooms = hotel.getAttributes().getHotelRooms();
			Assert.notEmpty(hotelRooms, "Lista de quartos não pode ser null e deve conter pelo menos um elemento.");

			ArrayList<EhtlHotelTaxRS> hotelTaxes = hotel.getAttributes().getHotelTaxes();
			Assert.notEmpty(hotelTaxes, "Lista de taxas não pode ser null e deve conter pelo menos um elemento.");

			for (EhtlRoomRS room : hotelRooms) {

				Assert.hasLength(room.getRoomCode(), "Código do quarto não pode ser vazio.");
				Assert.notNull(room.getTotalRoomsPrice(), "Preço do quarto não pode ser null.");

			}
		}
	}

	@Test
	void detalhesDoQuartoService() throws JsonMappingException, JsonProcessingException, InvalidTokenException {

		EhtlService ehtlService = new EhtlService("85213", "agenciaws@050539464720802020");

		Calendar calendar = Calendar.getInstance();
		calendar.set(2020, 10, 10);

		Date checkin = calendar.getTime();

		// pega disponibilidade, guarda código hotel e código quarto necessários para
		// próximo request
		EhtlRS responseDisponibilidade = ehtlService.getDisponibilidade("Y2l0eS0yMDY", checkin, 2, 1);
		EhtlDataRS hoteisDisponibilidade = responseDisponibilidade.getData().get(1);
		EhtlHotelAvailabilitiesRS hotel = (EhtlHotelAvailabilitiesRS) hoteisDisponibilidade;

		// faz request de detalhes do quarto com códigos obtidos na disponibilidade
		EhtlRS responseDetalhesDoQuarto = ehtlService.getDetalhesDoQuarto(hotel.getId(),
				hotel.getAttributes().getHotelRooms().get(0).getRoomCode());
		EhtlDataRS detalhesDoQuarto = responseDetalhesDoQuarto.getData().get(0);
		EhtlDetailsHotelAvailabilitiesRS quarto = (EhtlDetailsHotelAvailabilitiesRS) detalhesDoQuarto;

		Assert.notEmpty(quarto.getAttributes().getRooms(), "Lista de quartos não pode ser vazia.");
		Assert.hasLength(quarto.getAttributes().getRooms().get(0).getCode(), "Código do quarto não pode ser vazio.");
		Assert.notNull(quarto.getAttributes().getRooms().get(0).getPriceWithTax(),
				"Preço do quarto não pode ser nulo.");

		Assert.notNull(quarto.getAttributes().getCancellationDeadline(), "Data de cancelamento não pode ser nulo.");
		Assert.notNull(quarto.getAttributes().getTotalPrice(), "Preço do quarto não pode ser nulo.");
		Assert.notNull(quarto.getAttributes().getCancellationFee(), "Taxa de cancelamento não pode ser nulo.");
	}

	@Test
	void reservaFaturado() throws JsonProcessingException, InvalidTokenException {

		EhtlService ehtlService = new EhtlService("85213", "agenciaws@050539464720802020");

		Calendar calendar = Calendar.getInstance();
		calendar.set(2020, 10, 10);

		Date checkin = calendar.getTime();

		// pega disponibilidade, guarda código hotel e código quarto necessários para
		// próximo request
		EhtlRS responseDisponibilidade = ehtlService.getDisponibilidade("Y2l0eS0yMDY", checkin, 2, 1);
		EhtlDataRS hoteisDisponibilidade = responseDisponibilidade.getData().get(1);
		EhtlHotelAvailabilitiesRS hotel = (EhtlHotelAvailabilitiesRS) hoteisDisponibilidade;

		// faz request de detalhes do quarto com códigos obtidos na disponibilidade
		EhtlRS responseDetalhesDoQuarto = ehtlService.getDetalhesDoQuarto(hotel.getId(),
				hotel.getAttributes().getHotelRooms().get(0).getRoomCode());
		responseDetalhesDoQuarto.getData().get(0);

		// seta passageiro do quarto que será reservado.
		EhtlRoomPassengerRQ roomsPassenger = new EhtlRoomPassengerRQ();
		roomsPassenger.setName("Giovanna");
		roomsPassenger.setLastName("Lucchesi");
		roomsPassenger.setEmail("glucchesi@gmail.com");

		EhtlPassengerRQ passengers = new EhtlPassengerRQ();
		passengers.setRoomsPassenger(roomsPassenger);

		// seta objeto para request de reserva
		EhtlCompleteBookingProcessRQ reservaModel = new EhtlCompleteBookingProcessRQ();
		reservaModel.setName("Fernando Ribeiro");
		reservaModel.setLastName("Ribeiro");
		reservaModel.setEmail("fribeiro@lemontech.com.br");
		reservaModel.setPhone(31386248);
		reservaModel.setPassengers(passengers);
		reservaModel.setPaymentsTypes(EhtlPaymentTypeRQ.invoice_daily_and_extras);

		EhtlRS response = ehtlService.criaReserva(reservaModel);

		EhtlDataRS getReserva = response.getData().get(0);

		EhtlBookingRS reserva = (EhtlBookingRS) getReserva;

		Assert.notNull(reserva.getAttributes().getLocatorCode(), "Localizador não pode ser null.");
		Assert.notNull(reserva.getAttributes().getDeadlineCancellation(), "Prazo de cancelamento não pode ser null.");
	}

	@Test
	void cancelaReserva() throws JsonMappingException, JsonProcessingException, InvalidTokenException {

		EhtlService ehtlService = new EhtlService("85213", "agenciaws@050539464720802020");

		Calendar calendar = Calendar.getInstance();
		calendar.set(2020, 10, 10);

		Date checkin = calendar.getTime();

		// pega disponibilidade, guarda código hotel e código quarto necessários para
		// próximo request
		EhtlRS responseDisponibilidade = ehtlService.getDisponibilidade("Y2l0eS0yMDY", checkin, 2, 1);
		EhtlDataRS hoteisDisponibilidade = responseDisponibilidade.getData().get(1);
		EhtlHotelAvailabilitiesRS hotel = (EhtlHotelAvailabilitiesRS) hoteisDisponibilidade;

		// faz request de detalhes do quarto com códigos obtidos na disponibilidade
		EhtlRS responseDetalhesDoQuarto = ehtlService.getDetalhesDoQuarto(hotel.getId(),
				hotel.getAttributes().getHotelRooms().get(0).getRoomCode());
		responseDetalhesDoQuarto.getData().get(0);

		// seta passageiro do quarto que será reservado.
		EhtlRoomPassengerRQ roomsPassenger = new EhtlRoomPassengerRQ();
		roomsPassenger.setName("Giovanna");
		roomsPassenger.setLastName("Lucchesi");
		roomsPassenger.setEmail("glucchesi@gmail.com");

		EhtlPassengerRQ passengers = new EhtlPassengerRQ();
		passengers.setRoomsPassenger(roomsPassenger);

		// seta objeto para request de reserva
		EhtlCompleteBookingProcessRQ reservaModel = new EhtlCompleteBookingProcessRQ();
		reservaModel.setName("Fernando Ribeiro");
		reservaModel.setLastName("Ribeiro");
		reservaModel.setEmail("fribeiro@lemontech.com.br");
		reservaModel.setPhone(31386248);
		reservaModel.setPassengers(passengers);
		reservaModel.setPaymentsTypes(EhtlPaymentTypeRQ.invoice_daily_and_extras);

		// cria reserva
		EhtlRS responseCriarReserva = ehtlService.criaReserva(reservaModel);
		EhtlDataRS getReserva = responseCriarReserva.getData().get(0);
		EhtlBookingRS reserva = (EhtlBookingRS) getReserva;

		// cancela reserva
		EhtlRS responseCancelarReserva = ehtlService.cancelaReserva(reserva.getId());
		EhtlDataRS getCancelamento = responseCancelarReserva.getData().get(0);
		EhtlCancelBookingRS responseCancelamento = (EhtlCancelBookingRS) getCancelamento;

		Assert.isTrue(responseCancelamento.getAttributes().isCanceled(), "Reserva deve estar cancelada.");
	}

	@Test
	void getIdCidade() throws JsonMappingException, JsonProcessingException, InvalidTokenException {

		EhtlService ehtlService = new EhtlService("85213", "agenciaws@050539464720802020");

		ArrayList<EhtlDataRS> response = ehtlService.getIdCidade("São Paulo").getData();
		
		double latitudeSaoPaulo = -23.5505199;
		double longitudeSaoPaulo = -46.6333094;
		
		ArrayList<EhtlSearchCitiesRS> cidades = new ArrayList<>();
		
		for (EhtlDataRS cidadesResponse : response) {
			
			EhtlSearchCitiesRS cidade = (EhtlSearchCitiesRS) cidadesResponse;
			cidades.add(cidade);			
		}

		Optional<EhtlSearchCitiesRS> cidade = cidades.stream().filter(c -> c.getAttributes().getLatitude() == latitudeSaoPaulo &&
				c.getAttributes().getLongitude() == longitudeSaoPaulo).findFirst();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(2020, 10, 10);
		
		ArrayList<EhtlDataRS> disponibilidade = ehtlService.getDisponibilidade(cidade.get().getId(), calendar.getTime(), 2, 1)
				.getData();
		
		Assert.notEmpty(disponibilidade, "Lista de disponibilidade não pode ser vazia.");
	}

}