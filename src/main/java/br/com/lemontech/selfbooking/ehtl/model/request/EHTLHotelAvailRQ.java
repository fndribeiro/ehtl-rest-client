package br.com.lemontech.selfbooking.ehtl.model.request;

import java.util.ArrayList;
import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EHTLHotelAvailRQ extends EHTLAttributesRQ {

	private String destinationId;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Calendar checkin;	
	private int nights;
	private int roomsAmount;
	private ArrayList<EHTLRoomRQ> rooms = new ArrayList<>();
	
	// true retorna somente tarifa comissionada
	private boolean signsInvoice = false;
	
	
	public String getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}

	public Calendar getCheckin() {
		return checkin;
	}

	public void setCheckin(int year, int month, int date) {
		
		Calendar checkin = Calendar.getInstance();
		checkin.set(year, month, date);
		
		this.checkin = checkin;
	}

	public int getNights() {
		return nights;
	}

	public void setNights(int nights) {
		
		validaArgumento(nights);
		this.nights = nights;
	}

	public int getRoomsAmount() {
		return roomsAmount;
	}

	public void setRoomsAmount(int roomsAmount) {
		
		validaArgumento(roomsAmount);
		this.roomsAmount = roomsAmount;
	}

	public boolean isSignsInvoice() {
		return signsInvoice;
	}

	public void setSignsInvoice(boolean signsInvoice) {
		this.signsInvoice = signsInvoice;
	}

	public ArrayList<EHTLRoomRQ> getRooms() {
		return rooms;
	}

	public void setRooms(int adults) {
		
		validaArgumento(adults);
		EHTLRoomRQ room = new EHTLRoomRQ();
		room.setAdults(adults);
		this.rooms.add(room);
	}

	private void validaArgumento(int i) {

		if (i <= 0) {
			throw new IllegalArgumentException("Parâmetro não pode ser menor or igual a zero.");
		}
	}

}
