package com.wbd.kotki.web.dtos;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class CatDTO {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="Pole ovowiązkowe")
	@Past(message="Data musi być z przeszłosci")
	private Date birthdayDate;
	@NotBlank(message = "Pole obowiązkowe")
	@Pattern(regexp = "[\\p{Alpha}\\p{IsLatin}]+", message="Pole musi składać się z samych liter")
	private String name;
	@NotBlank(message = "Pole obowiązkowe")
	@Pattern(regexp = "[M|K]{1}", message = "K albo M")
	private String sex;
	@NotBlank(message = "Pole obowiązkowe")
	@Pattern(regexp = "[T|N]{1}", message = "T albo N")
	private String paws;
	@NotBlank(message = "Pole obowiązkowe")
	@Pattern(regexp = "[N|T]{1}", message = "T albo N")
	private String sterizlization;
	@NotBlank(message = "Pole obowiązkowe")
	@Pattern(regexp = "[T|N]{1}", message = "T albo N")
	private String sight;
	@NotBlank(message = "Pole obowiązkowe")
	@Pattern(regexp = "[\\p{Alpha}\\p{IsLatin}]+", message="Pole musi składać się z samych liter")
	private String race;
	public Date getBirthdayDate() {
		return birthdayDate;
	}
	public void setBirthdayDate(Date birthdayDate) {
		this.birthdayDate = birthdayDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPaws() {
		return paws;
	}
	public void setPaws(String paws) {
		this.paws = paws;
	}
	public String getSterizlization() {
		return sterizlization;
	}
	public void setSterizlization(String sterizlization) {
		this.sterizlization = sterizlization;
	}
	public String getSight() {
		return sight;
	}
	public void setSight(String sight) {
		this.sight = sight;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	
}
