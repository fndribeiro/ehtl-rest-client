package br.com.lemontech.selfbooking.ehtl.model.request;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EhtlHotelAvailabilitiesRQ extends EhtlAttributesRQ {

	private String destinationId;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date checkin;
	private int nights;
	private int roomsAmount;
	private ArrayList<EhtlRoomRQ> rooms = new ArrayList<>();

	// true retorna somente tarifa comissionada
	private boolean signsInvoice = false;

	public EhtlHotelAvailabilitiesRQ() {
	}

	public String getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
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
		
		for (int i = 1; i <= roomsAmount; i++) {
			EhtlRoomRQ room = new EhtlRoomRQ();
			room.setAdults(1);
			this.rooms.add(room);
		}
		
		this.roomsAmount = roomsAmount;
	}

	public boolean isSignsInvoice() {
		return signsInvoice;
	}

	public void setSignsInvoice(boolean signsInvoice) {
		this.signsInvoice = signsInvoice;
	}

	public ArrayList<EhtlRoomRQ> getRooms() {
		return rooms;
	}

	private void validaArgumento(int i) {

		if (i <= 0) {
			throw new IllegalArgumentException("Parâmetro não pode ser menor or igual a zero.");
		}
	}

}
