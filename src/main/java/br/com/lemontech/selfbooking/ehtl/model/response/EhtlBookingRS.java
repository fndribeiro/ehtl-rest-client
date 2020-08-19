package br.com.lemontech.selfbooking.ehtl.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EhtlBookingRS extends EhtlDataRS {

	private EhtlBookingAttributesRS attributes;

	public EhtlBookingRS() {
	}

	public EhtlBookingAttributesRS getAttributes() {
		return attributes;
	}

	public void setAttributes(EhtlBookingAttributesRS attributes) {
		this.attributes = attributes;
	}
}
