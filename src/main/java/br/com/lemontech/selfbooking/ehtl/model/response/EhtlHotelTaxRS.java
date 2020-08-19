package br.com.lemontech.selfbooking.ehtl.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class EhtlHotelTaxRS {

	private String currency;
	private String description;
	private boolean isAdditional;
	private boolean isPercentage;
	private String name;
	private boolean perNight;
	private boolean perPerson;
	private boolean perRoom;
	private boolean perStay;
	private String type;
	private double value;
	
	public EhtlHotelTaxRS() {
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAdditional() {
		return isAdditional;
	}

	public void setAdditional(boolean isAdditional) {
		this.isAdditional = isAdditional;
	}

	public boolean isPercentage() {
		return isPercentage;
	}

	public void setPercentage(boolean isPercentage) {
		this.isPercentage = isPercentage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPerNight() {
		return perNight;
	}

	public void setPerNight(boolean perNight) {
		this.perNight = perNight;
	}

	public boolean isPerPerson() {
		return perPerson;
	}

	public void setPerPerson(boolean perPerson) {
		this.perPerson = perPerson;
	}

	public boolean isPerRoom() {
		return perRoom;
	}

	public void setPerRoom(boolean perRoom) {
		this.perRoom = perRoom;
	}

	public boolean isPerStay() {
		return perStay;
	}

	public void setPerStay(boolean perStay) {
		this.perStay = perStay;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
