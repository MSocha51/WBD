package com.wbd.kotki.application.servicies;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbd.kotki.model.entities.Cat;
import com.wbd.kotki.model.repositories.CatRepository;

@Service
public class CatService {

	@Autowired
	private CatRepository catRepo;
	
	public List<Cat> getCatsList(){
		List<Cat> catList = new LinkedList<Cat>();
		catRepo.findAll().forEach( (x) -> catList.add(x) );
		return catList;
	}
}
