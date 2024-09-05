package com.myproj.DTOs;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.persistence.Cacheable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
@Component("logindto")
@Entity
@Table(name ="persons")

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class LoginRegisterDTO implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "personID")
	private int personid;	
	@Column(name = "FirstName")
	private String  Fname;
	@Column(name = "LastName")
	private String LastName;
	@Column(name = "Address")
	private String  Address;
	@Column(name = "City")
	private String city;
	@Column(name = "email")
	private String Email;
	@Column(name = "password")
	private String password;
	@Column(name = "gender")
	private String Gender;	
	@Column(name = "contact_no")
	private Long contactno;	
	@Column(name = "username")
	private String username;

	/*
	 * @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "prd") thhis  for  if  we are usinng mapping and need  cache both 
	 * 
	 * @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	 * //@JoinColumn(name = "sbid") private List<Subcat> subcls;
	 */
	private boolean flag;
	@Column(name = "role")
	private String  role;
	
	

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getOntactno() {
		return contactno;
	}
	public void setOntactno(Long ontactno) {
		this.contactno = ontactno;
	}
	@Override
	public String toString() {
		return "loginRegiDto [personid=" + personid + ", Fname=" + Fname + ", LastName=" + LastName + ", Address="
				+ Address + ", city=" + city + ", Email=" + Email + ", password=" + password + ", Gender=" + Gender
				+ ", ontactno=" + contactno + ", username=" + username + ", flag=" + flag + ", Contact=" + Contact
				+ ", isFlag()=" + isFlag() + ", getUsername()=" + getUsername() + ", getOntactno()=" + getOntactno()
				+ ", getPersonid()=" + getPersonid() + ", getFname()=" + getFname() + ", getLastName()="
				+ getLastName() + ", getAddress()=" + getAddress() + ", getCity()=" + getCity() + ", getEmail()="
				+ getEmail() + ", getPassword()=" + getPassword() + ", getGender()=" + getGender()
				+ ", getContact()=" + getContact() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	@Transient
	private Long Contact;
	
	@Column(name = "CRT_DT")
	private String date;
	public int getPersonid() {
		return personid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public Long getContact() {
		return Contact;
	}
	public void setContact(Long contact) {
		Contact = contact;
	}
public void show() {
	System.out.println("component  as class  bean ");
}  
}


