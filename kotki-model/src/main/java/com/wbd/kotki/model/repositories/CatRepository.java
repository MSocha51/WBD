package com.wbd.kotki.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wbd.kotki.model.entities.Cat;

@Repository
public interface CatRepository extends CrudRepository<Cat, Long>{

}
