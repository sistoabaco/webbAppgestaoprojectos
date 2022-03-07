package com.webbappgestaoprojectos.controller;

import com.webbappgestaoprojectos.repository.UtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UtilizadorController {

    @Autowired
    UtilizadorRepository ur;

    @RequestMapping(value = "/listaUtilizador", method = RequestMethod.GET)
    public String listaUtilizador(Model model){
        model.addAttribute("utilizadores", ur.findAll());
        return "lista_utilizador";
    }
}
