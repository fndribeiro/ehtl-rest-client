package br.com.lemontech.selfbooking.ehtl.model.request;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EhtlCompleteBookingProcessRQ extends EhtlAttributesRQ {
	
	//solicitante
	private String name;
	private String lastName;
	private String email;	
	private int phone;
	
	private ArrayList<EhtlPassengerRQ> passengers = new ArrayList<>();;
	private EhtlPaymentTypeRQ paymentsTypes;
	
	// campos abaixo necessários somente para pagamento cartao
	private String customerName;
	private String customerEmail;
	
	// CPF titular cartao
	private String customerIdentity;
	private String customerAddress;
	private String customerState;
	private String customerCity;
	private String customerPostalCode;
	private String customerStreetComplement;
	private String customerPhone;
	
	// fingerprint capturar do browser do usuario
	private String customerSessionId;
	
	// pegar na sessao do usuario
	private String customerIp;
	
	// nome titular cartao
	private String cardHolder;
	private String cardNumber;
	
	@JsonFormat(pattern = "MM/YYYY")
	private Date cardExpirationDate;
	private int cardSecurityCode;
	private EhtlCardFlagRQ cardFlag;
	
	public EhtlCompleteBookingProcessRQ() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public ArrayList<EhtlPassengerRQ> getPassengers() {
		return passengers;
	}

	public void setPassengers(EhtlPassengerRQ passengers) {
		this.passengers.add(passengers);
	}

	public EhtlPaymentTypeRQ getPaymentsTypes() {
		return paymentsTypes;
	}

	public void setPaymentsTypes(EhtlPaymentTypeRQ paymentsTypes) {
		this.paymentsTypes = paymentsTypes;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerIdentity() {
		return customerIdentity;
	}

	public void setCustomerIdentity(String customerIdentity) {
		this.customerIdentity = customerIdentity;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerPostalCode() {
		return customerPostalCode;
	}

	public void setCustomerPostalCode(String customerPostalCode) {
		this.customerPostalCode = customerPostalCode;
	}

	public String getCustomerStreetComplement() {
		return customerStreetComplement;
	}

	public void setCustomerStreetComplement(String customerStreetComplement) {
		this.customerStreetComplement = customerStreetComplement;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerSessionId() {
		return customerSessionId;
	}

	public void setCustomerSessionId(String customerSessionId) {
		this.customerSessionId = customerSessionId;
	}

	public String getCustomerIp() {
		return customerIp;
	}

	public void setCustomerIp(String customerIp) {
		this.customerIp = customerIp;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getCardExpirationDate() {
		return cardExpirationDate;
	}

	public void setCardExpirationDate(Date cardExpirationDate) {
		this.cardExpirationDate = cardExpirationDate;
	}

	public int getCardSecurityCode() {
		return cardSecurityCode;
	}

	public void setCardSecurityCode(int cardSecurityCode) {
		this.cardSecurityCode = cardSecurityCode;
	}

	public EhtlCardFlagRQ getCardFlag() {
		return cardFlag;
	}

	public void setCardFlag(EhtlCardFlagRQ cardFlag) {
		this.cardFlag = cardFlag;
	}
}	
