package com.wbd.kotki.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wbd.kotki.model.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
