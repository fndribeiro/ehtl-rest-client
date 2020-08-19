package br.com.lemontech.selfbooking.ehtl.model.response;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EhtlHotelRS {
	
	private boolean acceptsDirectPayment;
	private boolean agencyIsCommissioned;
	private boolean breakfastIncluded;
	private boolean featured;
	private String hotel;	
	private String hotelAddress;
	private ArrayList<String> hotelImages;
	private double hotelLowerPrice;
	private String hotelNeighborhood;
	private ArrayList<String> hotelRemarks;
	private ArrayList<EhtlRoomRS> hotelRooms;
	private int hotelStars;
	private ArrayList<EhtlHotelTaxRS> hotelTaxes;
	private boolean invoiceDaily;
	private boolean invoiceExtras;
	private boolean irrevocableGuarantee;
	private boolean onlyCreditCard;
	private boolean prePayment;
	
	public EhtlHotelRS() {
	}

	public EhtlHotelRS(boolean acceptsDirectPayment, boolean agencyIsCommissioned, boolean breakfastIncluded,
			boolean featured, String hotel, String hotelAddress, ArrayList<String> hotelImages, double hotelLowerPrice,
			String hotelNeighborhood, ArrayList<String> hotelRemarks, ArrayList<EhtlRoomRS> hotelRooms, int hotelStars,
			ArrayList<EhtlHotelTaxRS> hotelTaxes, boolean invoiceDaily, boolean invoiceExtras,
			boolean irrevocableGuarantee, boolean onlyCreditCard, boolean prePayment) {
		this.acceptsDirectPayment = acceptsDirectPayment;
		this.agencyIsCommissioned = agencyIsCommissioned;
		this.breakfastIncluded = breakfastIncluded;
		this.featured = featured;
		this.hotel = hotel;
		this.hotelAddress = hotelAddress;
		this.hotelImages = hotelImages;
		this.hotelLowerPrice = hotelLowerPrice;
		this.hotelNeighborhood = hotelNeighborhood;
		this.hotelRemarks = hotelRemarks;
		this.hotelRooms = hotelRooms;
		this.hotelStars = hotelStars;
		this.hotelTaxes = hotelTaxes;
		this.invoiceDaily = invoiceDaily;
		this.invoiceExtras = invoiceExtras;
		this.irrevocableGuarantee = irrevocableGuarantee;
		this.onlyCreditCard = onlyCreditCard;
		this.prePayment = prePayment;
	}

	public boolean isAcceptsDirectPayment() {
		return acceptsDirectPayment;
	}

	public void setAcceptsDirectPayment(boolean acceptsDirectPayment) {
		this.acceptsDirectPayment = acceptsDirectPayment;
	}

	public boolean isAgencyIsCommissioned() {
		return agencyIsCommissioned;
	}

	public void setAgencyIsCommissioned(boolean agencyIsCommissioned) {
		this.agencyIsCommissioned = agencyIsCommissioned;
	}

	public boolean isBreakfastIncluded() {
		return breakfastIncluded;
	}

	public void setBreakfastIncluded(boolean breakfastIncluded) {
		this.breakfastIncluded = breakfastIncluded;
	}

	public boolean isFeatured() {
		return featured;
	}

	public void setFeatured(boolean featured) {
		this.featured = featured;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public ArrayList<String> getHotelImages() {
		return hotelImages;
	}

	public void setHotelImages(ArrayList<String> hotelImages) {
		this.hotelImages = hotelImages;
	}

	public double getHotelLowerPrice() {
		return hotelLowerPrice;
	}

	public void setHotelLowerPrice(double hotelLowerPrice) {
		this.hotelLowerPrice = hotelLowerPrice;
	}

	public String getHotelNeighborhood() {
		return hotelNeighborhood;
	}

	public void setHotelNeighborhood(String hotelNeighborhood) {
		this.hotelNeighborhood = hotelNeighborhood;
	}

	public ArrayList<String> getHotelRemarks() {
		return hotelRemarks;
	}

	public void setHotelRemarks(ArrayList<String> hotelRemarks) {
		this.hotelRemarks = hotelRemarks;
	}

	public ArrayList<EhtlRoomRS> getHotelRooms() {
		return hotelRooms;
	}

	public void setHotelRooms(ArrayList<EhtlRoomRS> hotelRooms) {
		this.hotelRooms = hotelRooms;
	}

	public int getHotelStars() {
		return hotelStars;
	}

	public void setHotelStars(int hotelStars) {
		this.hotelStars = hotelStars;
	}

	public ArrayList<EhtlHotelTaxRS> getHotelTaxes() {
		return hotelTaxes;
	}

	public void setHotelTaxes(ArrayList<EhtlHotelTaxRS> hotelTaxes) {
		this.hotelTaxes = hotelTaxes;
	}

	public boolean isInvoiceDaily() {
		return invoiceDaily;
	}

	public void setInvoiceDaily(boolean invoiceDaily) {
		this.invoiceDaily = invoiceDaily;
	}

	public boolean isInvoiceExtras() {
		return invoiceExtras;
	}

	public void setInvoiceExtras(boolean invoiceExtras) {
		this.invoiceExtras = invoiceExtras;
	}

	public boolean isIrrevocableGuarantee() {
		return irrevocableGuarantee;
	}

	public void setIrrevocableGuarantee(boolean irrevocableGuarantee) {
		this.irrevocableGuarantee = irrevocableGuarantee;
	}

	public boolean isOnlyCreditCard() {
		return onlyCreditCard;
	}

	public void setOnlyCreditCard(boolean onlyCreditCard) {
		this.onlyCreditCard = onlyCreditCard;
	}

	public boolean isPrePayment() {
		return prePayment;
	}

	public void setPrePayment(boolean prePayment) {
		this.prePayment = prePayment;
	}
}
