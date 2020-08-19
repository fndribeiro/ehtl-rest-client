package br.com.lemontech.selfbooking.ehtl.model.response;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class EhtlRoomRS {
	
	private boolean irrevocableGuarantee;
	private String roomCode;
	private ArrayList<EhtlRoomDetailRS> roomsDetail;
	private double totalRoomsPrice;
	private double totalRoomsPriceWithTax;
	
	public EhtlRoomRS() {	
	}

	public boolean isIrrevocableGuarantee() {
		return irrevocableGuarantee;
	}

	public void setIrrevocableGuarantee(boolean irrevocableGuarantee) {
		this.irrevocableGuarantee = irrevocableGuarantee;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public ArrayList<EhtlRoomDetailRS> getRoomsDetail() {
		return roomsDetail;
	}

	public void setRoomsDetail(ArrayList<EhtlRoomDetailRS> roomsDetail) {
		this.roomsDetail = roomsDetail;
	}

	public double getTotalRoomsPrice() {
		return totalRoomsPrice;
	}

	public void setTotalRoomsPrice(double totalRoomsPrice) {
		this.totalRoomsPrice = totalRoomsPrice;
	}

	public double getTotalRoomsPriceWithTax() {
		return totalRoomsPriceWithTax;
	}

	public void setTotalRoomsPriceWithTax(double totalRoomsPriceWithTax) {
		this.totalRoomsPriceWithTax = totalRoomsPriceWithTax;
	}	
}
