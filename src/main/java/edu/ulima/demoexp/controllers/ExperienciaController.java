package edu.ulima.demoexp.controllers;

import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import edu.ulima.demoexp.model.*;
import edu.ulima.demoexp.repository.*;
import edu.ulima.demoexp.repository.ExperienciasRepositorio;

@Controller
@RequestMapping("/experiencias")
public class ExperienciaController {
    private ExperienciasRepositorio eRepository;

    @Autowired
    public ExperienciaController(ExperienciasRepositorio eRepository){
        this.eRepository = eRepository;
    }

    @RequestMapping(value= "/{iduser}",method = RequestMethod.GET)
    public String experienciasUser(@PathVariable("iduser") Long iduser, 
                                Model model) {
        List<Experiencias> listaExperiencias = eRepository.findByIduser(iduser);
        if (listaExperiencias != null) {
            model.addAttribute("misExperiencias", listaExperiencias);
        }
        return "experiencias";
    }

    @RequestMapping(value = "/{iduser}", method = RequestMethod.POST)
    public String actualizar(HttpServletRequest req,String idaeditar){

        Experiencias current =null;
        Long newid = Long.parseLong(idaeditar);
        req.getSession().setAttribute("expeditar", newid);

        System.out.println(req.getSession().getAttribute("expeditar").toString());
        System.out.println("-");
        System.out.println(req.getSession().getAttribute("expeditar").toString());

        Optional<Experiencias> e = eRepository.findById(newid);
        if(e.isPresent()){
            current = e.get();
            req.getSession().setAttribute("iduser", current.getIduser());
            req.getSession().setAttribute("entidad", current.getEntidad());
            req.getSession().setAttribute("ocupacion", current.getOcupacion());
            req.getSession().setAttribute("logro", current.getLogro());
            req.getSession().setAttribute("fechaini", current.getFechaini());
            req.getSession().setAttribute("fechafin", current.getFechafin());
        }else{
            return "redirect:/actu/";
        }
        return "redirect:/actu/";
        


    }
    
}