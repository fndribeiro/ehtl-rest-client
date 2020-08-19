package br.com.lemontech.selfbooking.ehtl.model.request;

public class EhtlDataRQ {

	private final EhtlAttributesRQ attributes;

	public EhtlDataRQ(EhtlAttributesRQ attributes) {
		this.attributes = attributes;
	}

	public EhtlAttributesRQ getAttributes() {
		return attributes;
	}
}
