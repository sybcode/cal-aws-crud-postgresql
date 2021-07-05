package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Amazoncal;
import com.example.demo.repositories.AmazoncalRepository;
import com.example.demo.service.IAmazoncalService;

@Service
public class AmazoncalServiceImpl implements IAmazoncalService {

	@Autowired
	private AmazoncalRepository mR;

	@Override
	public void insert(Amazoncal mc) {
		mR.save(mc);/* Spring Data */
	}

	@Override
	public List<Amazoncal> list() {
		// TODO Auto-generated method stub
		return mR.findAll();
	}

	@Override
	public Optional<Amazoncal> listId(int idamazoncal) {		
		return mR.findById(idamazoncal);
	}
	
	@Override
	public void delete(int idamazoncal) {
		mR.deleteById(idamazoncal);
		
	}

}
