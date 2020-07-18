package edu.ulima.demoexp.controllers;

import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import edu.ulima.demoexp.model.*;


import edu.ulima.demoexp.repository.*;
import edu.ulima.demoexp.repository.ExperienciasRepositorio;

@Controller
@RequestMapping("/actu")
public class ActuController {
    private ExperienciasRepositorio eRepository;

    @Autowired
    public ActuController(ExperienciasRepositorio eRepository){
        this.eRepository = eRepository;
    }

    @RequestMapping(value= "/",method = RequestMethod.GET)
    public String experienciasUser(Model model) {
        
        model.addAttribute("formulario", new FormularioExp());

        return "actu";
    }
    
    @RequestMapping(value= "/enviarmod",method = RequestMethod.POST)
    public String actualizarUser(HttpServletRequest req,@ModelAttribute FormularioExp f) {
        
        Experiencias current = null;
        Long idnuevo = (Long) req.getSession().getAttribute("expeditar");
        
        Optional<Experiencias> e = eRepository.findById(idnuevo);

        if(e.isPresent()) {
            current = e.get();
            current.setEntidad(f.getCampo1());
            current.setOcupacion(f.getCampo2());
            current.setLogro(f.getCampo3());
            current.setFechaini(f.getCampo5());
            current.setFechafin(f.getCampo6());
            current.setVisibilidad(f.getCampo4());
            eRepository.saveAndFlush(current);


            return "redirect:/experiencias/" + f.getCampo0();

        }else{
            return "redirect:/experiencias/" + f.getCampo0();
        }

        

    }
    


    
}