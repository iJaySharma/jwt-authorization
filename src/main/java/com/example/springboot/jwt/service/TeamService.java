package com.example.springboot.jwt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.jwt.entity.Company;
import com.example.springboot.jwt.entity.Team;
import com.example.springboot.jwt.repository.TeamRepository;

@Service
public class TeamService {
@Autowired
TeamRepository teamRepository;

public Team createTeam(Team team)   
{  
return teamRepository.save(team);
}

public List<Team> getTeam()   
{  
	List<Team> teams = new ArrayList<Team>();  	
	teamRepository.findAll().forEach(team -> teams.add(team));
	return teams;
}

public List<Team> getAllTeamByCompanyId(Company company)   
{  
	return teamRepository.findAllTeamsByCompanyEquals(company);
}

}

