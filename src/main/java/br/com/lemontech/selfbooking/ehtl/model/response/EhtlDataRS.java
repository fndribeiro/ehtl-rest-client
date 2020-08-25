package br.com.lemontech.selfbooking.ehtl.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ 
	@Type(value = EhtlHotelAvailabilitiesRS.class, name = "hotelsAvailabilities"),
	@Type(value = EhtlDetailsHotelAvailabilitiesRS.class, name = "bookingDetail"),
	@Type(value = EhtlBookingRS.class, name = "booking"),
	@Type(value = EhtlCancelBookingRS.class, name = "book-cancel"),
	@Type(value = EhtlSearchCitiesRS.class, name = "cities")
})
public abstract class EhtlDataRS {
	
	private String type;
	private String id;
	
	public EhtlDataRS() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
