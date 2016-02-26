package com.services;

import java.util.List;

import com.domain.Company;

public interface CompanyService {
	
	Company saveCompany(Company company);
	
	List<Company> listAllCompanies();
	
	Company getCompanyById(long id);
	
}
