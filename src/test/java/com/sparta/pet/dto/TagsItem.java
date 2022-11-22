package com.sparta.pet.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TagsItem{

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	public TagsItem(){
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