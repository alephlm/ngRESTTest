package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.domain.BeneficialOwner;
import com.domain.Company;
import com.services.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	private CompanyService companyService;

	@Autowired
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Company saveCompany(@RequestBody Company company) {
		return companyService.saveCompany(company);																																																																																																																
	}
	
	@RequestMapping(value = "/listall", method = RequestMethod.GET)
	public List<Company> listAllCompanies() {
		return companyService.listAllCompanies();																																																																																																																
	}
	
	@RequestMapping(value = "/companyDetails/{companyId}", method = RequestMethod.GET)
	public Company getCompanyById(@PathVariable long companyId) {
		return companyService.getCompanyById(companyId);																																																																																																																
	}
	
	@RequestMapping(value = "addBeneficialOwner/{companyId}", method = RequestMethod.POST)
	public Company AddBeneficialOwner(@RequestBody BeneficialOwner beneficialOwner, @PathVariable long companyId) {
		Company company = companyService.getCompanyById(companyId);
		company.addBeneficialOwner(beneficialOwner);
		return companyService.saveCompany(company);
	}
	
}
