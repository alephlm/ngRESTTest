package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}
