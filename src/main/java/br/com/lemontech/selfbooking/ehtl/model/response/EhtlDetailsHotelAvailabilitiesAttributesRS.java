package br.com.lemontech.selfbooking.ehtl.model.response;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EhtlDetailsHotelAvailabilitiesAttributesRS {
	
	@JsonAlias({"Rooms"})
	private ArrayList<EhtlRoomDetailRS> rooms;
	private String policiesAdministration;
	private String policiesCancellations;
	private String policiesConsiderations;
	private String currency;
	private double totalPrice;
	private double totalPriceWithTax;
	private ArrayList<String> acceptedPaymentsTypes;
	private Date cancellationDeadline;
	private double cancellationFee;
	private boolean prePayment;
	private boolean agencyPrepayment;
	private double taxeAdministrativeWithCreditCard;
	private String checkInHour;
	private String checkOutHour;
	private boolean agencyIsCommissioned;

	public EhtlDetailsHotelAvailabilitiesAttributesRS() {
	}

	public ArrayList<EhtlRoomDetailRS> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<EhtlRoomDetailRS> rooms) {
		this.rooms = rooms;
	}

	public String getPoliciesAdministration() {
		return policiesAdministration;
	}

	public void setPoliciesAdministration(String policiesAdministration) {
		this.policiesAdministration = policiesAdministration;
	}

	public String getPoliciesCancellations() {
		return policiesCancellations;
	}

	public void setPoliciesCancellations(String policiesCancellations) {
		this.policiesCancellations = policiesCancellations;
	}

	public String getPoliciesConsiderations() {
		return policiesConsiderations;
	}

	public void setPoliciesConsiderations(String policiesConsiderations) {
		this.policiesConsiderations = policiesConsiderations;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getTotalPriceWithTax() {
		return totalPriceWithTax;
	}

	public void setTotalPriceWithTax(double totalPriceWithTax) {
		this.totalPriceWithTax = totalPriceWithTax;
	}

	public ArrayList<String> getAcceptedPaymentsTypes() {
		return acceptedPaymentsTypes;
	}

	public void setAcceptedPaymentsTypes(ArrayList<String> acceptedPaymentsTypes) {
		this.acceptedPaymentsTypes = acceptedPaymentsTypes;
	}

	public Date getCancellationDeadline() {
		return cancellationDeadline;
	}

	public void setCancellationDeadline(Date cancellationDeadline) {
		this.cancellationDeadline = cancellationDeadline;
	}

	public double getCancellationFee() {
		return cancellationFee;
	}

	public void setCancellationFee(double cancellationFee) {
		this.cancellationFee = cancellationFee;
	}

	public boolean isPrePayment() {
		return prePayment;
	}

	public void setPrePayment(boolean prePayment) {
		this.prePayment = prePayment;
	}

	public boolean isAgencyPrepayment() {
		return agencyPrepayment;
	}

	public void setAgencyPrepayment(boolean agencyPrepayment) {
		this.agencyPrepayment = agencyPrepayment;
	}

	public double getTaxeAdministrativeWithCreditCard() {
		return taxeAdministrativeWithCreditCard;
	}

	public void setTaxeAdministrativeWithCreditCard(double taxeAdministrativeWithCreditCard) {
		this.taxeAdministrativeWithCreditCard = taxeAdministrativeWithCreditCard;
	}

	public String getCheckInHour() {
		return checkInHour;
	}

	public void setCheckInHour(String checkInHour) {
		this.checkInHour = checkInHour;
	}

	public String getCheckOutHour() {
		return checkOutHour;
	}

	public void setCheckOutHour(String checkOutHour) {
		this.checkOutHour = checkOutHour;
	}

	public boolean isAgencyIsCommissioned() {
		return agencyIsCommissioned;
	}

	public void setAgencyIsCommissioned(boolean agencyIsCommissioned) {
		this.agencyIsCommissioned = agencyIsCommissioned;
	}
}
