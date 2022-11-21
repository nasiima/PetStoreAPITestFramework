package com.sparta.pet.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

	@JsonProperty("petId")
	private int petId;

	@JsonProperty("quantity")
	private int quantity;

	@JsonProperty("id")
	private int id;

	@JsonProperty("shipDate")
	private String shipDate;

	@JsonProperty("complete")
	private boolean complete;

	@JsonProperty("status")
	private String status;

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPetId(){
		return petId;
	}

	public int getQuantity(){
		return quantity;
	}

	public int getId(){
		return id;
	}

	public String getShipDate(){
		return shipDate;
	}

	public boolean isComplete(){
		return complete;
	}

	public String getStatus(){
		return status;
	}
}