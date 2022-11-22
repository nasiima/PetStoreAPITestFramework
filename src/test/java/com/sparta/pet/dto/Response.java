package com.sparta.pet.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response{

	@JsonProperty("photoUrls")
	private List<String> photoUrls;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	@JsonProperty("category")
	private Category category;

	@JsonProperty("tags")
	private List<TagsItem> tags;

	@JsonProperty("status")
	private String status;

	public List<String> getPhotoUrls(){
		return photoUrls;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public Category getCategory(){
		return category;
	}

	public List<TagsItem> getTags(){
		return tags;
	}

	public String getStatus(){
		return status;
	}

}