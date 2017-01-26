package com.wbd.kotki.application.servicies;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import com.wbd.kotki.model.entities.Cat;
import com.wbd.kotki.model.entities.Race;
import com.wbd.kotki.model.repositories.CatRepository;
import com.wbd.kotki.model.repositories.RaceReposiotry;
import com.wbd.kotki.web.dtos.CatDTO;

@Service
public class CatService {

	@Autowired
	private CatRepository catRepo;
	@Autowired
	private RaceReposiotry raceRepo;
	
	public List<Cat> getCatsList(){
		List<Cat> catList = new LinkedList<Cat>();
		catRepo.findAll().forEach( (x) -> catList.add(x) );
		return catList;
	}
	
	public List<Cat> getUnadopptedCatList(){
		List<Cat> catList = new LinkedList<Cat>();
		catRepo.findUnaddoptedCats().forEach( (x) -> catList.add(x) );
		return catList; 
	}
	
	public Cat getByID(Long id){
		Cat cat=catRepo.findOne(id);
		return cat;
	}

	public Long addCat(CatDTO catDto) {
		Cat cat = createCat(catDto);
		Race race = raceRepo.findByRaceNameIgnoreCase(catDto.getRace());
		if(race == null){
			race = new Race();
			race.setRaceName(catDto.getRace());
			race = raceRepo.save(race);
		}
		cat.setRace(race);
		cat = catRepo.save(cat);
		return cat.getId();
	}

	private Cat createCat(CatDTO catDto) {
		Cat cat = new Cat();
		Function<String, Character> encode = (from) -> from.charAt(0);
		cat.setBirthdayDate(catDto.getBirthdayDate());
		cat.setName(catDto.getName());
		cat.setPaws(encode.apply(catDto.getPaws()));
		cat.setSex(encode.apply(catDto.getSex()));
		cat.setSight(encode.apply(catDto.getSight()));
		cat.setSterizlization(encode.apply(catDto.getSterizlization()));
		return cat;
	}

	
}
