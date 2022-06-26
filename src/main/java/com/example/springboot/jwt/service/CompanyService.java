package com.example.springboot.jwt.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.jwt.entity.Company;
import com.example.springboot.jwt.repository.CompanyRepository;


@Service
public class CompanyService {
	@Autowired  
	CompanyRepository companyRepository;  
	
	@Autowired
	TeamService teamService;
	
	public List<Company> getAllCompany()   
	{  
	List<Company> companies = new ArrayList<Company>();  
	companyRepository.findAll().forEach(company -> companies.add(company));  
	return companies;  
	}  
	
	public Company createCompany(Company company)   
	{  
	return companyRepository.save(company);
	}

	public Company fetchCompany(int id) {
		return companyRepository.findById(id).get();
	}

	public List<Company> fetchCompanyByName(String name) {
		// TODO Auto-generated method stub
		return companyRepository.findAllByCompanyNameEquals(name);
	}

	public List<Company> allTeamsByCompany() {
		List<Company> companies = new ArrayList<Company>();  
		companyRepository.findAll().forEach(company ->{
			company.setListTeam(teamService.getAllTeamByCompanyId(company));
			companies.add(company);} );  
		return companies;  	}  
}
