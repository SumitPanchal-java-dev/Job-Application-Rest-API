package com.embarkx.firstjobapp.review;

import com.embarkx.firstjobapp.company.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String description;
	private Double rating;
	
	@JsonIgnore
	@ManyToOne
	private Company compnay;

	public Review() {

	}

	public Review(Integer id, String title, String description, Double rating, Company compnay) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.rating = rating;
		this.compnay = compnay;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Company getCompnay() {
		return compnay;
	}

	public void setCompnay(Company compnay) {
		this.compnay = compnay;
	}

	

}
