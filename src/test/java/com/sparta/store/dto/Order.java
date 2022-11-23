package com.sparta.store.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

import java.util.Date;

public class Order {

	@JsonProperty("id")
	private int id;

	@JsonProperty("petId")
	private int petId;

	@JsonProperty("quantity")
	private int quantity;

	@JsonProperty("shipDate")
	public String shipDate;

	@JsonProperty("status")
	private String status;

	@JsonProperty("complete")
	private boolean complete;

	public Order (int id, int petId, int quantity, String shipDate, String status, boolean complete) {
		this.id = id;
		this.petId = petId;
		this.quantity = quantity;
		this.shipDate = shipDate;
		this.status = status;
		this.complete = complete;
	}

	public Order (int id, int petId, int quantity, String status, boolean complete) {
		this.id = id;
		this.petId = petId;
		this.quantity = quantity;
		this.shipDate = LocalDate.now().toString();
		this.status = status;
		this.complete = complete;
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