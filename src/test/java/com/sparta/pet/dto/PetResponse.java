package com.sparta.pet.dto;

import java.util.List;

public class PetResponse {
	private List<String> photoUrls;
	private String name;
	private int id;
	private Category category;
	private List<TagsItem> tags;
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