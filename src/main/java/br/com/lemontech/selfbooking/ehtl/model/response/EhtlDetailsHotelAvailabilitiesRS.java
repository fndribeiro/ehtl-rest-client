package br.com.lemontech.selfbooking.ehtl.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EhtlDetailsHotelAvailabilitiesRS extends EhtlDataRS {

	private EhtlDetailsHotelAvailabilitiesAttributesRS attributes;
	
	
	public EhtlDetailsHotelAvailabilitiesRS() {
	}

	public EhtlDetailsHotelAvailabilitiesAttributesRS getAttributes() {
		return attributes;
	}

	public void setAttributes(EhtlDetailsHotelAvailabilitiesAttributesRS attributes) {
		this.attributes = attributes;
	}
}
