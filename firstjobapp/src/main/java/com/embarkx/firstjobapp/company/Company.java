package com.embarkx.firstjobapp.company;

import java.util.List;

import com.embarkx.firstjobapp.job.Job;
import com.embarkx.firstjobapp.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy="company")
	private List<Job> jobs;
	
	@OneToMany(mappedBy="company")
	private List<Review> review;

	public Company() {
		
	}

	public Company(Integer id, String name, String description, List<Job> jobs, List<Review> review) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.jobs = jobs;
		this.review = review;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	
	
	
}
