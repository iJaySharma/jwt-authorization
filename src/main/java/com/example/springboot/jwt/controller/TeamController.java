package com.example.springboot.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.jwt.entity.Team;
import com.example.springboot.jwt.service.CompanyService;
import com.example.springboot.jwt.service.TeamService;

@RestController
public class TeamController {
@Autowired
TeamService teamService;

@Autowired
CompanyService companyService;

@PostMapping("/createTeam/{companyId}")  
private Team createTeam(@PathVariable Integer companyId, @RequestBody Team team)   
{  
	 team.setCompany(companyService.fetchCompany(companyId));
	 return teamService.createTeam(team);  
}


}

