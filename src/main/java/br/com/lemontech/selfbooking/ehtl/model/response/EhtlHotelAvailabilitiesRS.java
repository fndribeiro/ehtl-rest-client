package br.com.lemontech.selfbooking.ehtl.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EhtlHotelAvailabilitiesRS extends EhtlDataRS {
	
	private EhtlHotelRS attributes;
	
	public EhtlHotelAvailabilitiesRS() {
	}

	public EhtlHotelRS getAttributes() {
		return attributes;
	}

	public void setAttributes(EhtlHotelRS attributes) {
		this.attributes = attributes;
	}
}
