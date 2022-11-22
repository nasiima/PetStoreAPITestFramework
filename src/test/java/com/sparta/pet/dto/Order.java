package com.sparta.pet.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Order {

	@JsonProperty("petId")
	private int petId;

	@JsonProperty("quantity")
	private int quantity;

	@JsonProperty("id")
	private int id;

	@JsonProperty("shipDate")
	private Date shipDate;

	@JsonProperty("complete")
	private boolean complete;

	@JsonProperty("status")
	private String status;

	public Order (int petId, int quantity, int id, Date shipDate, boolean complete, String status) {
		this.petId = petId;
		this.quantity = quantity;
		this.id = id;
		this.shipDate = shipDate;
		this.complete = complete;
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