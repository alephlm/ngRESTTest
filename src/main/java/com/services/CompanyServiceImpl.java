package com.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.BeneficialOwner;
import com.domain.Company;
import com.repositories.CompanyRepository;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService{

	private final CompanyRepository repository;
	
	@Autowired
	public CompanyServiceImpl(CompanyRepository repository) {
		this.repository = repository;
	}

	@Override
	public Company saveCompany(Company company) {
		if(company.getId() != 0) {
			for(BeneficialOwner bo : company.getBeneficialOwners()) {
				company.addBeneficialOwner(bo);
			}
		}
		return repository.save(company);
	}

	@Override
	public List<Company> listAllCompanies() {
		return repository.findAll();
	}

	@Override
	public Company getCompanyById(long id) {
		return repository.findOne(id);
	}

}
