package com.webbappgestaoprojectos.controller;

import com.webbappgestaoprojectos.model.Projecto;
import com.webbappgestaoprojectos.repository.ProjectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjectoController {
    @Autowired
    ProjectoRepository projectoRepository;

    @RequestMapping("/listaProjecto")
    public String listaProjecto(Model model){
        model.addAttribute("projecto", projectoRepository.findAll());
        return"lista_projecto";
    }

    @RequestMapping("/salvarProjecto")
    public String cadastroProjecto(){
        return"formulario_Projecto";
    }

    @RequestMapping(value = "/salvarProjecto", method = RequestMethod.POST)
    public String salvarProjecto(Projecto projecto, Model model){
        projectoRepository.save(projecto);
        return"redirect:/listaProjecto";
    }

}
