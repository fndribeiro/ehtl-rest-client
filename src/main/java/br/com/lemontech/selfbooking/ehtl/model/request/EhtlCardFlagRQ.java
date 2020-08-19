package br.com.lemontech.selfbooking.ehtl.model.request;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EhtlCardFlagRQ {

	VISA(500),
	MASTERCARD(501),
	AMEX(502),
	DINERS(503),
	ELO(504),
	Test(997);
	
	private int flagId;

	private EhtlCardFlagRQ(int i) {
		this.flagId = i;
	}

	@JsonValue
	public int getFlagId() {
		return flagId;
	}	
}
