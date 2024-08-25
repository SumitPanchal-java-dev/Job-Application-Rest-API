package com.embarkx.firstjobapp.company.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.embarkx.firstjobapp.company.Company;
import com.embarkx.firstjobapp.company.CompanyRepository;
import com.embarkx.firstjobapp.company.CompanyService;


@Service
public class CompanyServiceImplementation implements CompanyService {

	private CompanyRepository companyrepo;

	public CompanyServiceImplementation(CompanyRepository companyrepo) {
		this.companyrepo = companyrepo;
	}

	@Override
	public List<Company> getAllCompanies() {

		return companyrepo.findAll();
	}

	@Override
	public boolean updateCompany(Integer id, Company updatedcompany) {
		Optional<Company> comoptional = companyrepo.findById(id);
		if (comoptional.isPresent()) {
			Company company = comoptional.get();
			company.setName(updatedcompany.getName());
			company.setDescription(updatedcompany.getDescription());
			company.setJobs(updatedcompany.getJobs());
			companyrepo.save(company);
			return true;
		}
		return false;
	}

	@Override
	public void createCompany(Company company) {

		companyrepo.save(company);
	}

	@Override
	public boolean deleteCompany(Integer id) {
		if (companyrepo.existsById(id)) {
			companyrepo.deleteById(id);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Company getCompany(Integer id) {
		return companyrepo.findById(id).orElse(null);
	}

}
