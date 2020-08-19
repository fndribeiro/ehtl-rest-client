package br.com.lemontech.selfbooking.ehtl.model.request;

public class EhtlRQ {

	private final EhtlDataRQ data;

	public EhtlRQ(EhtlDataRQ data) {
		this.data = data;
	}

	public EhtlDataRQ getData() {
		return data;
	}
}
