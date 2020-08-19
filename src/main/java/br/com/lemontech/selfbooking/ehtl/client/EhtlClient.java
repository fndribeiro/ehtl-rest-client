package br.com.lemontech.selfbooking.ehtl.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import br.com.lemontech.selfbooking.ehtl.model.response.EhtlTokenRS;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Component
public class EhtlClient {

	private final Logger log = LoggerFactory.getLogger(EhtlClient.class);
	private final String baseUrl = "http://integration-quasar.e-htl.com.br";

	private WebClient webClient;

	public EhtlClient() {
		this.webClient = WebClient.create(baseUrl);
	}	
	
	public WebClient getWebClient() {
		return webClient;
	}
	
	// monta webclient com logger no request.
	public WebClient getLoggerWebClient() {
		
		WebClient webClient = WebClient.builder().baseUrl(baseUrl)
				.clientConnector(new ReactorClientHttpConnector(
	                HttpClient.create().wiretap(true)
	            ))
	            .build();
		
		return webClient;
	}

	// monta o request com token no header
	public  RequestBodySpec setTokenRequest(RequestBodySpec request, EhtlTokenRS token) {

		String header = token.getTokenType() + " " + token.getAccessToken();
		return request.header("Authorization", header);
	}

	// pega response e monta em classe mono<string>
	public Mono<String> getResponse(RequestHeadersSpec<?> request) {

		return request.exchange().flatMap(response -> response.bodyToMono(String.class).doOnSuccess(body -> {
			if (response.statusCode().isError()) {
				log.error("HttpStatusCode = {}", response.statusCode());
				log.error("ResponseBody = {}", body);
			}
		}));
	}
}
