package com.example.springboot.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.jwt.entity.Company;
import com.example.springboot.jwt.service.CompanyService;


@RestController
@RequestMapping("manageCompany")
public class CompanyController {

	@Autowired  
	CompanyService companyService;  
	
	@GetMapping("/getCompany")  
    @PreAuthorize("hasAuthority('TEAM_MEMBER')")
	public List<Company> getAllCompany()   
	{  
	return companyService.getAllCompany();  
	}  
	
	@PostMapping("/createCompany")  
    @PreAuthorize("hasAuthority('TEAM_MEMBER')")
	public Company company(@RequestBody Company company)   
	{  
	return companyService.createCompany(company);  
	}
	

	
	@GetMapping("/companyById/{id}")  
    @PreAuthorize("hasAuthority('TEAM_MEMBER')")
	public Company CompanyById(@PathVariable Integer id)   
	{  
	return companyService.fetchCompany(id);  
	}
	
	@GetMapping("/companyByName/{name}")  
    @PreAuthorize("hasAuthority('TEAM_MEMBER')")
	public List<Company> CompanyByName(@PathVariable String name)   
	{  
	return companyService.fetchCompanyByName(name);  
	}
	

	@GetMapping("/allTeamsByCompany")  
    @PreAuthorize("hasAnyAuthority('TEAM_MEMBER', 'ADMIN')")
	public List<Company> allTeamsByCompany()   
	{  
	List<Company> companies = companyService.allTeamsByCompany();  
	return companies;
	}
	
}
