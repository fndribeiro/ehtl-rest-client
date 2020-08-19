package br.com.lemontech.selfbooking.ehtl.model.request;

import java.util.ArrayList;

public class EhtlPassengerRQ {

	private ArrayList<EhtlRoomPassengerRQ> roomsPassenger = new ArrayList<>();;

	public EhtlPassengerRQ() {
	}

	public ArrayList<EhtlRoomPassengerRQ> getRoomsPassenger() {
		return roomsPassenger;
	}

	public void setRoomsPassenger(EhtlRoomPassengerRQ roomsPassenger) {	
		this.roomsPassenger.add(roomsPassenger);
	}
}
