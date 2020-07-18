package edu.ulima.demoexp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

import edu.ulima.demoexp.model.*;
import edu.ulima.demoexp.repository.UsuariosRepositorio;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
    private UsuariosRepositorio uRepository;
    
    @Autowired
    public UsuariosController(UsuariosRepositorio uRepository){
        this.uRepository = uRepository;
    }

    @RequestMapping(value= "/",method = RequestMethod.GET)
    public String listarUsuarios(Model model) 
    {
        List<Usuario> listaUsuarios = uRepository.findAll(); 
        if (listaUsuarios != null) {
            model.addAttribute("Usuarios", listaUsuarios);
        }
        return "usuarios";
    }
    
}

// prueba asdfghjkl.ñ-