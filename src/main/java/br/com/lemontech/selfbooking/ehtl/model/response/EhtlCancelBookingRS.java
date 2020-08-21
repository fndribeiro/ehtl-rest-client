package br.com.lemontech.selfbooking.ehtl.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EhtlCancelBookingRS extends EhtlDataRS {

	private EhtlCancelBookingAttributesRS attributes;

	public EhtlCancelBookingRS() {
	}

	public EhtlCancelBookingAttributesRS getAttributes() {
		return attributes;
	}

	public void setAttributes(EhtlCancelBookingAttributesRS attributes) {
		this.attributes = attributes;
	}
}
