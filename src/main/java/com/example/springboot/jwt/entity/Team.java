package com.example.springboot.jwt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Team_New")
public class Team {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="code")
private int code;

@ManyToOne//(fetch = FetchType.LAZY)
@JoinColumn(name = "company_id")
private Company company;

@Column(name="teamLead")
private String teamLead;




public String getTeamLead() {
	return teamLead;
}

public void setTeamLead(String teamLead) {
	this.teamLead = teamLead;
}

public Team(int code, String teamLead) {
	super();
	this.code = code;
	this.teamLead = teamLead;
}

public Company getCompany() {
	return company;
}

public void setCompany(Company company) {
	this.company = company;
}

public Team() {
	super();
	// TODO Auto-generated constructor stub
}

public int getCode() {
	return code;
}

public void setCode(int code) {
	this.code = code;
}
}
