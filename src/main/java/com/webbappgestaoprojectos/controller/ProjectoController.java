package com.webbappgestaoprojectos.controller;

import com.webbappgestaoprojectos.model.Projecto;
import com.webbappgestaoprojectos.repository.FuncionarioRepository;
import com.webbappgestaoprojectos.repository.ProjectoRepository;
import com.webbappgestaoprojectos.repository.UtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String cadastroProjecto(Model model){
        model.addAttribute("projecto", new Projecto());
        return"formulario_projecto";
    }

    @RequestMapping(value = "/salvarProjecto", method = RequestMethod.POST)
    public String salvarProjecto(Projecto projecto, Model model){
        projectoRepository.save(projecto);
        return"redirect:/listaProjecto";
    }

    @GetMapping("/editProjecto/{idProjecto}")
    public String editFormProjecto(@PathVariable("idProjecto") Integer idProjecto, Model model){
        model.addAttribute("projecto", projectoRepository.findById(idProjecto).get());
        return "formulario_projecto";
    }

    @GetMapping("/deleteProjecto/{idProjecto}")
    public String deleteProjecto(@PathVariable("idProjecto") Integer idProjecto){
        projectoRepository.deleteById(idProjecto);
        return "redirect:/listaProjecto";
    }
}
