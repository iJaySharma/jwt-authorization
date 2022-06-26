package com.example.springboot.jwt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.springboot.jwt.entity.Company;

public interface CompanyRepository extends CrudRepository<Company, Integer>  
{

	List<Company> findAllByCompanyNameEquals(String name);  
}  

