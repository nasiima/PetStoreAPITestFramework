package com.sparta.pet.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category{

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	public Category(){
		this.id = id;
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}
}