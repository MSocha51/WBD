package com.wbd.kotki.model.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="ROLE",
uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_ROLI" }),
		@UniqueConstraint(columnNames = { "NAZWA" }) })
public class Role {
	@Id
	@GeneratedValue
	@Column(name="ID_ROLI",unique=true,nullable=false)
	private Long id;
	@Column(name="NAZWA",unique=true,nullable=false)
	private String name;
	@OneToMany(mappedBy= "role")
	private Set<User> user = new HashSet<User>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
	
	
}
