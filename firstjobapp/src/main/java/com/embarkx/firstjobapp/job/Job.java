package com.embarkx.firstjobapp.job;

import com.embarkx.firstjobapp.company.Company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Job {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String description;
	private String minsalary;
	private String maxsalary;
	private String location;
	
	@ManyToOne
	private Company company;

	public Job() {

	}

	public Job(Integer id, String title, String description, String minsalary, String maxsalary, String location,
			Company company) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.minsalary = minsalary;
		this.maxsalary = maxsalary;
		this.location = location;
		this.company = company;
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

	public String getMinsalary() {
		return minsalary;
	}

	public void setMinsalary(String minsalary) {
		this.minsalary = minsalary;
	}

	public String getMaxsalary() {
		return maxsalary;
	}

	public void setMaxsalary(String maxsalary) {
		this.maxsalary = maxsalary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	
}
