package com.wbd.kotki.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wbd.kotki.model.entities.Client;

public interface ClientRepository  extends CrudRepository<Client,Long>{

}
