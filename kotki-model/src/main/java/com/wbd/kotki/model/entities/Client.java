package com.wbd.kotki.model.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "KLIENCI", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_KLIENTA" }),
		@UniqueConstraint(columnNames = { "MAIL" }), @UniqueConstraint(columnNames = { "PESEL" }) })
public class Client {
	@Id
	@GeneratedValue
	@Column(name = "ID_KLIENTA", nullable = false, unique = true)
	private Long id;
	@Column(name = "IMIE", nullable = false)
	private String firstName;
	@Column(name = "NAZWISKO", nullable = false)
	private String surname;
	@Column(name = "PESEL", nullable = false, unique = true)
	private Integer pesel;
	@Column(name = "ULICA", nullable = false)
	private String street;
	@Column(name = "MIASTO", nullable = false)
	private String city;
	@Column(name = "KOD_POCZTOWY", nullable = false)
	private String postCode;
	@Column(name = "NR_LOKALU", nullable = false)
	private String localNumber;
	@Column(name = "TELEFON", nullable = false)
	private Integer phone;
	@Column(name = "MAIL", nullable = false, unique = true)
	private String mail;
	@OneToMany(mappedBy="owner")
	private Set<Cat> addoptedCat = new HashSet<Cat>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Integer getPesel() {
		return pesel;
	}
	public void setPesel(Integer pesel) {
		this.pesel = pesel;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getLocalNumber() {
		return localNumber;
	}
	public void setLocalNumber(String localNumber) {
		this.localNumber = localNumber;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Set<Cat> getAddoptedCat() {
		return addoptedCat;
	}
	public void setAddoptedCat(Set<Cat> addoptedCat) {
		this.addoptedCat = addoptedCat;
	}
	
	
	
}
