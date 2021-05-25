package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UtenteController {
	
    @RequestMapping(value= {"/","/home"}, method = RequestMethod.GET)
    public String getHome(Model model) {
        return "home.html";
    }
    
    @RequestMapping(value= "/collezioni", method = RequestMethod.GET)
    public String getCollezioni(Model model) {
        return "collezioniAll.html";
    }
    
    @RequestMapping(value= "/opere", method = RequestMethod.GET)
    public String getOpere(Model model) {
        return "opereAll.html";
    }
    @RequestMapping(value= "/artisti", method = RequestMethod.GET)
    public String getArtisti(Model model) {
        return "artistiAll.html";
    }
    
    
    
}
