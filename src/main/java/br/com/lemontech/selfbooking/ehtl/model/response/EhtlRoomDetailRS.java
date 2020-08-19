package br.com.lemontech.selfbooking.ehtl.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class EhtlRoomDetailRS {
	
	private int id;
	private String code;
	private int count;
	private int adults;
	private boolean breakfast;
	private String currency;
	private boolean irrevocableGuarantee;
	private double price;
	private double priceWithTax;
	private String regime;
	private String regimeDescription;
	private String roomDescription;
	private String roomName;
	private String type;
	
	public EhtlRoomDetailRS() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public boolean isBreakfast() {
		return breakfast;
	}

	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public boolean isIrrevocableGuarantee() {
		return irrevocableGuarantee;
	}

	public void setIrrevocableGuarantee(boolean irrevocableGuarantee) {
		this.irrevocableGuarantee = irrevocableGuarantee;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPriceWithTax() {
		return priceWithTax;
	}

	public void setPriceWithTax(double priceWithTax) {
		this.priceWithTax = priceWithTax;
	}

	public String getRegime() {
		return regime;
	}

	public void setRegime(String regime) {
		this.regime = regime;
	}

	public String getRegimeDescription() {
		return regimeDescription;
	}

	public void setRegimeDescription(String regimeDescription) {
		this.regimeDescription = regimeDescription;
	}

	public String getRoomDescription() {
		return roomDescription;
	}

	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
