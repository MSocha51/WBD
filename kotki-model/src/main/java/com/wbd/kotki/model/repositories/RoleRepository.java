package com.wbd.kotki.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wbd.kotki.model.entities.Role;

public interface RoleRepository  extends CrudRepository<Role,Long>{
	
	public Role findByName(String name);
}
