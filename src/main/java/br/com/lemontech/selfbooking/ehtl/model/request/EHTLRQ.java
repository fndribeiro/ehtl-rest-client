package br.com.lemontech.selfbooking.ehtl.model.request;

public class EHTLRQ {

	private final EHTLDataRQ data;

	public EHTLRQ(EHTLDataRQ data) {
		this.data = data;
	}

	public EHTLDataRQ getData() {
		return data;
	}
}
