package com.wbd.kotki.web.dtos;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class RegisterDTO {
	@NotBlank(message="Pole obowiązkowe")
	@Size(min=3, max=15, message="Imie powinno mieścić się miedzy 3 a 15 znakami")
	private String firstName;
	
	@NotBlank(message="Pole obowiązkowe")
	@Size(min=3, max=20, message="Nazwisko powinno mieścić się miedzy 3 a 20 znakami")
	private String surname;
	
	@NotBlank(message="Pole obowiązkowe")
	@Digits(fraction = 0, integer = 11, message="Nieprawidłowy PESEL")
	private String pesel;
	
	@NotBlank(message="Pole obowiązkowe")
	@Size(min=3, max=30, message="Nulica powinna mieścić sie miedzy 3 a 30 znakami")
	private String street;
	
	@NotBlank(message="Pole obowiązkowe")
	@Size(min=3, max=20, message="Miasto powinno mieścić sie miedzy 3 a 20 znakami")
	private String city;
	
	@NotBlank(message="Pole obowiązkowe")
	@Pattern(regexp = "\\d\\d-\\d\\d\\d", message="Nieprawidłowy format 00-000")
	private String postCode;
	
	@NotBlank(message="Pole obowiązkowe")
	@Size(min=0, max=6, message="Maksymalnie 6 znaków")
	private String localNumber;
	
	@NotBlank(message="Pole obowiązkowe")
	@Digits(fraction = 0, integer = 11, message="Nieprawidłowy telefon")
	private String phone;
	
	@NotBlank(message="Pole obowiązkowe")
	@Email(message="Prosze wpisać mail")
	private String mail;
	

	@NotBlank(message="Pole obowiązkowe")
	@Size(min=6,message="Hasło musi mieć przynajmiej 6 znaków")
	private String password;

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

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
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
		RegisterDTO other = (RegisterDTO) obj;
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
		return "RegisterDTO [firstName=" + firstName + ", surname=" + surname + ", pesel=" + pesel + ", street="
				+ street + ", city=" + city + ", postCode=" + postCode + ", localNumber=" + localNumber + ", phone="
				+ phone + ", mail=" + mail + "]";
	}
	
	
}
