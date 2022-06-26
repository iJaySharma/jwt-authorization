package com.example.springboot.jwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.springboot.jwt.entity.Company;
import com.example.springboot.jwt.entity.Team;

public interface TeamRepository extends CrudRepository<Team, Integer>  {
	

	@Query("select new com.example.springboot.jwt.entity.Team(d.code, d.teamLead) from Team d where d.company = ?1")
	List<Team> findAllTeamsByCompanyEquals(Company company);  

}
