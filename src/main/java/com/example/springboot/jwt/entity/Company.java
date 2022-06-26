package com.example.springboot.jwt.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Company_New")
public class Company {
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="companyName")
	private String companyName;
	@Column(name="companyCeo")
	private String companyCeo;
	@Column(name="address")
	private String address;
	@Column(name="inceptionDate")
	private String inceptionDate;
	//@OneToMany(targetEntity=Team.class)
	@Transient
	private List<Team> listTeam = new ArrayList<Team>();
	
	public Company(int id, String companyName, String companyCeo, String address, String inceptionDate) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.companyCeo = companyCeo;
		this.address = address;
		this.inceptionDate = inceptionDate;
		//this.listTeam = listTeam;
	}

	
	 public List<Team> getListTeam() { return listTeam; }
	 public void setListTeam(List<Team> listTeam) { this.listTeam = listTeam; }
	 
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}	
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyCeo() {
		return companyCeo;
	}
	public void setCompanyCeo(String companyCeo) {
		this.companyCeo = companyCeo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInceptionDate() {
		return inceptionDate;
	}
	public void setInceptionDate(String inceptionDate) {
		this.inceptionDate = inceptionDate;
	}
}
