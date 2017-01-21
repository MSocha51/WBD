package com.wbd.kotki.model.entities;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Cat {
	private Long id;
	private Date birthdayDate;
	private String name;
	private Character sex;
	private Boolean pawns;
	private Boolean sterizlization;
	private Boolean sight;
	private Race race;

}
