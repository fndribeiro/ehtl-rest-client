package br.com.lemontech.selfbooking.ehtl.model.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.lemontech.selfbooking.ehtl.util.MultiDateDeserializer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EhtlBookingAttributesRS {
	
	@JsonProperty("checkin") @JsonDeserialize(using = MultiDateDeserializer.class)
	private Date checkin;
	
	@JsonProperty("checkout") @JsonDeserialize(using = MultiDateDeserializer.class)
	private Date checkout;
	
	@JsonProperty("deadlineCancellation") @JsonDeserialize(using = MultiDateDeserializer.class)
	private Date deadlineCancellation;
	
	@JsonProperty("createdAt") @JsonDeserialize(using = MultiDateDeserializer.class)
	private Date createdAt;
	
	private double cancellationFee;
	private String specialRequests;
	private String sensitiveInformation;
	private boolean noShowAgency;
	private boolean irrevocableGuarantee;
	private String locatorCode;
	private String especificExtras;
	private double value;
	private double valueWithTax;
	private int statusId;	
	private boolean isOffline;
	private double clientCommissionPercent;
	private double clientCommissionValue;
	private String ehtlBookingNumber;
	
	public EhtlBookingAttributesRS() {
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public Date getDeadlineCancellation() {
		return deadlineCancellation;
	}

	

	public double getCancellationFee() {
		return cancellationFee;
	}

	public void setCancellationFee(double cancellationFee) {
		this.cancellationFee = cancellationFee;
	}

	public String getSpecialRequests() {
		return specialRequests;
	}

	public void setSpecialRequests(String specialRequests) {
		this.specialRequests = specialRequests;
	}

	public String getSensitiveInformation() {
		return sensitiveInformation;
	}

	public void setSensitiveInformation(String sensitiveInformation) {
		this.sensitiveInformation = sensitiveInformation;
	}

	public boolean isNoShowAgency() {
		return noShowAgency;
	}

	public void setNoShowAgency(boolean noShowAgency) {
		this.noShowAgency = noShowAgency;
	}

	public boolean isIrrevocableGuarantee() {
		return irrevocableGuarantee;
	}

	public void setIrrevocableGuarantee(boolean irrevocableGuarantee) {
		this.irrevocableGuarantee = irrevocableGuarantee;
	}

	public String getLocatorCode() {
		return locatorCode;
	}

	public void setLocatorCode(String locatorCode) {
		this.locatorCode = locatorCode;
	}

	public String getEspecificExtras() {
		return especificExtras;
	}

	public void setEspecificExtras(String especificExtras) {
		this.especificExtras = especificExtras;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getValueWithTax() {
		return valueWithTax;
	}

	public void setValueWithTax(double valueWithTax) {
		this.valueWithTax = valueWithTax;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public boolean isOffline() {
		return isOffline;
	}

	public void setOffline(boolean isOffline) {
		this.isOffline = isOffline;
	}

	public double getClientCommissionPercent() {
		return clientCommissionPercent;
	}

	public void setClientCommissionPercent(double clientCommissionPercent) {
		this.clientCommissionPercent = clientCommissionPercent;
	}

	public double getClientCommissionValue() {
		return clientCommissionValue;
	}

	public void setClientCommissionValue(double clientCommissionValue) {
		this.clientCommissionValue = clientCommissionValue;
	}

	public String getEhtlBookingNumber() {
		return ehtlBookingNumber;
	}

	public void setEhtlBookingNumber(String ehtlBookingNumber) {
		this.ehtlBookingNumber = ehtlBookingNumber;
	}
}
