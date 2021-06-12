package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.service.ArtistaService;
import com.example.demo.service.CuratoreService;
import com.example.demo.service.OperaService;

@Controller
public class OperaController {

	@Autowired
	ArtistaService artistaService;
	
	@Autowired
	CuratoreService curatoreService;

	@Autowired
	OperaService operaService;	
	
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
    
    @RequestMapping(value= "/admin/newOpera", method = RequestMethod.GET)
    public String newOpera(Model model) {
        model.addAttribute("opere", operaService.tutti());
    	return "opereAll.html";
    }
    
}
