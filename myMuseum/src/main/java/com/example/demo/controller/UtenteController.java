package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Artista;
import com.example.demo.model.Collezione;
import com.example.demo.model.Curatore;
import com.example.demo.model.Opera;
import com.example.demo.service.ArtistaService;
import com.example.demo.service.CollezioneService;
import com.example.demo.service.CuratoreService;
import com.example.demo.service.OperaService;

@Controller
public class UtenteController {
	
	
	@Autowired
	ArtistaService artistaService;
	
	@Autowired
	CollezioneService collezioneService;
	
	@Autowired
	CuratoreService curatoreService;
	

	@Autowired
	OperaService operaService;
	
	
    @RequestMapping(value= {"/","/home"}, method = RequestMethod.GET)
    public String getHome(Model model) {
    	
    	
    	
        return "home.html";
    }
    
    @RequestMapping(value= "/collezioni", method = RequestMethod.GET)
    public String getCollezioniAll(Model model) {
    	model.addAttribute("collezioni", collezioneService.tutti());
        return "collezioniAll.html";
    }
    
    @RequestMapping(value= "/collezioni/{id}", method = RequestMethod.GET)
    public String getCollezione(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("collezione", collezioneService.getById(id));
    	model.addAttribute("opere", collezioneService.getById(id).getOpere());
    	model.addAttribute("curatore", collezioneService.getById(id).getCuratore());
    	
        return "collezione.html";
    }
    
    
    @RequestMapping(value= "/opere", method = RequestMethod.GET)
    public String getOpereAll(Model model) {
        model.addAttribute("opere", operaService.tutti());
    	return "opereAll.html";
    }
  
    @RequestMapping(value= "/opere/{id}", method = RequestMethod.GET)
    public String getOpera(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("opera", operaService.getById(id));
    	model.addAttribute("collezione", operaService.getById(id).getCollezione());
    	model.addAttribute("artista", operaService.getById(id).getArtista());
        return "opera.html";
    }
    
    
    @RequestMapping(value= "/artisti", method = RequestMethod.GET)
    public String getArtisti(Model model) {
    	model.addAttribute("artisti", artistaService.tutti());
        return "artistiAll.html";
    }
    
    @RequestMapping(value= "/artisti/{id}", method = RequestMethod.GET)
    public String getArtista(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("artista", artistaService.getById(id));
    	model.addAttribute("opere", artistaService.getById(id).getOpere());
    	
    	
        return "artista.html";
    }
    
}
