package br.com.lemontech.selfbooking.ehtl.model.response;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EhtlRS {

	private ArrayList<EhtlDataRS> data;

	public EhtlRS() {
	}

	public ArrayList<EhtlDataRS> getData() {
		return data;
	}

	public void setData(ArrayList<EhtlDataRS> data) {
		this.data = data;
	}
}
