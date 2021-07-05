package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.PathVariable;


import com.example.demo.entities.Amazoncal;
import com.example.demo.service.IAmazoncalService;


@Controller
@RequestMapping("/amazoncals")
public class AmazoncalController {

	@Autowired//Inyección de dependencias
	private IAmazoncalService mService;

	@GetMapping("/new")
	public String newdepart(Model model) {
		model.addAttribute("amazoncal", new Amazoncal());
		return "amazoncal/amazoncal";

	}

	@PostMapping("/save")
	public String savedepart(@Validated @ModelAttribute(value = "amazoncal") Amazoncal amazoncal, BindingResult result,
			Model model, SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			return "amazoncal/amazoncal";
		} else {

			mService.insert(amazoncal);
			status.setComplete();
			return "redirect:/amazoncals/list";/* incompleto */
		}

	}

	/* listar */
	@GetMapping("/list")
	public String listamazoncal(Model model) {
		try {
			model.addAttribute("listaDeAmazoncal", mService.list());
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return "amazoncal/listamazoncal";
	}
	
	@GetMapping("/list/{idamazoncal}")
	public String listId(@PathVariable int idamazoncal,Model model) {
		model.addAttribute("amazoncal", mService.listId(idamazoncal));
		return "amazoncal/amazoncal";
	}
	
	@GetMapping("/delete/{idamazoncal}")
	public String eliminar(@PathVariable int idamazoncal,Model model) {
		mService.delete(idamazoncal);
		return "redirect:/amazoncals/list";
	}

}
