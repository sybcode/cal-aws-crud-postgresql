package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Amazoncal;


public interface IAmazoncalService {

	public void insert(Amazoncal mc);

	List<Amazoncal> list();

	public Optional<Amazoncal> listId(int idamazoncal);
	
	public void delete(int idamazoncal);

}
