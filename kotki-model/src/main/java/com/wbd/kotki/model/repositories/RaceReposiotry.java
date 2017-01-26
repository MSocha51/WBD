package com.wbd.kotki.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wbd.kotki.model.entities.Race;

public interface RaceReposiotry extends CrudRepository<Race, Long> {
	
	public Race findByRaceNameIgnoreCase(String Name);

}
