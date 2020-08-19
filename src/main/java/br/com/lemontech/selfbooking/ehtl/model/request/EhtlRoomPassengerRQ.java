package br.com.lemontech.selfbooking.ehtl.model.request;

public class EhtlRoomPassengerRQ {
	
	// viajante
	private String name;
	private String lastName;
	private String email;
	private int age = 30;
	private String type = "AD";
	
	public EhtlRoomPassengerRQ() {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
