package br.com.lemontech.selfbooking.ehtl.model.request;

public class EhtlDetailsHotelAvailabilitiesRQ extends EhtlAttributesRQ {

	private String hotelCode;
	private String roomCode;
	
	public EhtlDetailsHotelAvailabilitiesRQ() {
	}

	public String getHotelCode() {
		return hotelCode;
	}

	public void setHotelCode(String hotelCode) {
		this.hotelCode = hotelCode;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
}
