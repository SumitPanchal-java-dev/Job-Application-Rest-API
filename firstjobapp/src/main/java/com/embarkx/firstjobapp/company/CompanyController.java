package com.embarkx.firstjobapp.company;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

	private CompanyService service;

	public CompanyController(CompanyService service) {
		this.service = service;
	}

	@GetMapping("/companies")
	public List<Company> getAllCompanies() {
		return service.getAllCompanies();
	}

	@PutMapping("/companies/{id}")
	public String updateCompany(@PathVariable Integer id, @RequestBody Company company) {
		if (service.updateCompany(id, company)) {
			return "Success";
		}
		return null;
	}

	@PostMapping("/companies")
	public String addCompany(@RequestBody Company company) {
		service.createCompany(company);
		return "Success";
	}

	@DeleteMapping("/companies")
	public String deleteCompany(@PathVariable Integer id) {
		if (service.deleteCompany(id)) {
			return "Success";
		}
		return "Unsuccess";

	}
	
	@GetMapping("/companies/{id}")
	public Company getCompany(@PathVariable Integer id) {
		Company company = service.getCompany(id);
		if(company!=null) {
			return company;
		}else {
			return null;
		}
	}

}
