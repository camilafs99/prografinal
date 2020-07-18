package edu.ulima.demoexp.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.ulima.demoexp.model.FormularioCrearUsuario;
import edu.ulima.demoexp.model.Usuario;
import edu.ulima.demoexp.repository.UsuariosRepositorio;

@Controller
@RequestMapping("/crear_usuario")
public class CrearUsuario {

    private UsuariosRepositorio uRepository;    

    @Autowired
    public CrearUsuario(UsuariosRepositorio uRepository){
        this.uRepository = uRepository;
    }

    @RequestMapping(value="/",method=RequestMethod.GET)
    public String getAll(Model model){

        model.addAttribute("formularioUsuario", new FormularioCrearUsuario());

        return "crear_usuario";
    }

    @RequestMapping(value="/",method=RequestMethod.POST)
    public String processFormulario(@ModelAttribute FormularioCrearUsuario f,HttpServletRequest req)
    {

        Usuario user = new Usuario();

        user.setCorreo(f.getCampo1());
        user.setRol(f.getCampo2());
        user.setEstado(f.getCampo3());

        uRepository.save(user);

    //Cambiar a la siguiente Plantilla
        return "redirect:/usuarios/";
    }
}