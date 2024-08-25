package com.embarkx.firstjobapp.company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    boolean updateCompany(Integer id, Company company);

    void createCompany(Company company);

    boolean deleteCompany(Integer id);

    Company getCompany(Integer id);
}
