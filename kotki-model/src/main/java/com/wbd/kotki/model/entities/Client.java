package com.wbd.kotki.model.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PreRemove;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "KLIENCI", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_KLIENTA" }),
		@UniqueConstraint(columnNames = { "MAIL" }), @UniqueConstraint(columnNames = { "PESEL" }) })
public class Client {
	@Id
	@SequenceGenerator(name="SEQ_GEN", sequenceName="KLIENCI_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
	@Column(name = "ID_KLIENTA", nullable = false, unique = true)
	private Long id;
	@Column(name = "IMIE", nullable = false)
	private String firstName;
	@Column(name = "NAZWISKO", nullable = false)
	private String surname;
	@Column(name = "PESEL", nullable = false, unique = true)
	private Long pesel;
	@Column(name = "ULICA", nullable = false)
	private String street;
	@Column(name = "MIASTO", nullable = false)
	private String city;
	@Column(name = "KOD_POCZTOWY", nullable = false)
	private String postCode;
	@Column(name = "NR_LOKALU", nullable = false)
	private String localNumber;
	@Column(name = "TELEFON", nullable = false)
	private Long phone;
	@Column(name = "MAIL", nullable = false, unique = true)
	private String mail;
	@OneToMany(mappedBy="owner")
	private Set<Cat> addoptedCats = new HashSet<Cat>();
	@OneToOne(mappedBy="client", cascade=CascadeType.ALL)
	private User user;
	
	@PreRemove
	private void prepareToRemove(){
		addoptedCats.parallelStream().forEach((cat)->cat.setOwner(null));
	}
	
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
	public Long getPesel() {
		return pesel;
	}
	public void setPesel(Long pesel) {
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
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Set<Cat> getAddoptedCats() {
		return addoptedCats;
	}
	public void setAddoptedCats(Set<Cat> addoptedCats) {
		this.addoptedCats = addoptedCats;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((localNumber == null) ? 0 : localNumber.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((pesel == null) ? 0 : pesel.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((postCode == null) ? 0 : postCode.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (localNumber == null) {
			if (other.localNumber != null)
				return false;
		} else if (!localNumber.equals(other.localNumber))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (pesel == null) {
			if (other.pesel != null)
				return false;
		} else if (!pesel.equals(other.pesel))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (postCode == null) {
			if (other.postCode != null)
				return false;
		} else if (!postCode.equals(other.postCode))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", firstName=" + firstName + ", surname=" + surname + ", pesel=" + pesel
				+ ", street=" + street + ", city=" + city + ", postCode=" + postCode + ", localNumber=" + localNumber
				+ ", phone=" + phone + ", mail=" + mail + "]";
	}
	
	
	
}
