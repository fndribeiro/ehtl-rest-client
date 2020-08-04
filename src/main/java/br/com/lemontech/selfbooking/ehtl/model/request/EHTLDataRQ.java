package br.com.lemontech.selfbooking.ehtl.model.request;

public class EHTLDataRQ {

	private final EHTLAttributesRQ attributes;

	public EHTLDataRQ(EHTLAttributesRQ attributes) {
		this.attributes = attributes;
	}

	public EHTLAttributesRQ getAttributes() {
		return attributes;
	}
}
