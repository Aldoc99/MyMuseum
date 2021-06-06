package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Artista;
import com.example.demo.service.ArtistaService;
import com.example.demo.validator.ArtistaValidator;



@Controller
public class AmministratoreController {

	@Autowired
	ArtistaService artistaService;
	
	@Autowired
	ArtistaValidator artistaValidator;
	
	@RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public String getHomeIndex(Model model) {
		return "admin_home";
    }
	
	@RequestMapping(value="/admin/newArtista", method = RequestMethod.GET)
    public String newArtista(Model model) {
		model.addAttribute("artista", new Artista());
		return "formArtista";
    }
	@RequestMapping(value="/admin/newArtista", method = RequestMethod.POST)
	public String getArtista(@ModelAttribute("artista") Artista artista, 
			Model model, BindingResult bindingResult) {
		this.artistaValidator.validate(artista, bindingResult);
		if (!bindingResult.hasErrors()) {
			this.artistaService.inserisci(artista);
			model.addAttribute("artista", artista);
			return "artista";
		}
		return "formArtista";
	}
	
	

	
	
//	@RequestMapping(value="/admin/newCollezione", method = RequestMethod.GET)
//    public String newCollezioneChooseCuratore(Model model) {
//
//		return "formCollezionaCuratore";
//    }
//	
//	@RequestMapping(value="/admin/newCollezione/{idC}", method = RequestMethod.GET)
//    public String newCollezioneChooseCuratore(Model model) {
//
//		return "formCollezionaCuratore";
//    }
			
	
}
