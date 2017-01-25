package com.wbd.kotki.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
@Table(name="URZYTKOWNICY",
uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_URZYTKOWNIKA" }),
		@UniqueConstraint(columnNames = { "MAIL" }) })
public class User {
	@Id
	@GeneratedValue
	@Column(name="ID_URZYTKOWNIKA")
	private Long id;
	@Column(name = "MAIL", nullable = false, unique = true)
	private String mail;
	@Column(name = "HASLO",nullable = false)
	private String password;
	@ManyToOne
	@JoinColumn(name="ID_ROLI")
	private Role role;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
}
