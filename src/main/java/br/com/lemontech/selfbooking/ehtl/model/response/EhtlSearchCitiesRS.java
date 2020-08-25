package br.com.lemontech.selfbooking.ehtl.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EhtlSearchCitiesRS extends EhtlDataRS {

	private EhtlCityRS attributes;

	public EhtlSearchCitiesRS() {
	}

	public EhtlCityRS getAttributes() {
		return attributes;
	}

	public void setAttributes(EhtlCityRS attributes) {
		this.attributes = attributes;
	}
}
