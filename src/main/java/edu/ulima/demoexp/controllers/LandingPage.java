package edu.ulima.demoexp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.ulima.demoexp.model.*;
import edu.ulima.demoexp.repository.ExperienciasRepositorio;


@Controller
@RequestMapping("/")
public class LandingPage {

    private ExperienciasRepositorio eRepository;

    @Autowired
    public LandingPage(ExperienciasRepositorio eRepository){
        this.eRepository = eRepository;
    }
    
    @RequestMapping(value="/",method=RequestMethod.GET)
    public String getAll(Model model){

        model.addAttribute("formulario", new FormularioExp());

        return "index";

    }

    @RequestMapping(value="/",method=RequestMethod.POST)
    public String processForm(@ModelAttribute FormularioExp f,HttpServletRequest req){

        Experiencias Exp = new Experiencias();

        req.getSession().setAttribute("id", f.getCampo0());


        Exp.setIduser(Long.parseLong(f.getCampo0()));
        Exp.setEntidad(f.getCampo1());
        Exp.setOcupacion(f.getCampo2());
        Exp.setLogro(f.getCampo3());
        Exp.setVisibilidad(f.getCampo4());
        Exp.setFechaini(f.getCampo5());
        Exp.setFechafin(f.getCampo6());

        eRepository.save(Exp);


    //Cambiar a la siguiente Plantilla
    return "redirect:/experiencias/" + f.getCampo0();
    }
    


    
}