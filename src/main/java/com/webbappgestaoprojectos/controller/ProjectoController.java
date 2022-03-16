package com.webbappgestaoprojectos.controller;

import com.webbappgestaoprojectos.model.Projecto;
import com.webbappgestaoprojectos.repository.ProjectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

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
    public String salvarProjecto(Projecto projecto,  @RequestParam(value = "dataInicio",
            required = true) String dataI, @RequestParam(value = "dataFim", required = true) String dataF,Model model){
 
        projecto.setDataFim(Date.valueOf(dataI));
        projecto.setDataFim(Date.valueOf(dataF));

        projectoRepository.save(projecto);
        return"redirect:/listaProjecto";
    }

    @GetMapping("/editProjecto/{idProjecto}")
    public String editFormProjecto(@PathVariable("idProjecto") Integer idProjecto, Model model){
        model.addAttribute("projecto", projectoRepository.findById(idProjecto).get());
        return "edit_formulario_projecto";
    }

    @GetMapping("/apagarProjecto/{idProjecto}")
    public String apagarProjecto(@PathVariable("idProjecto") Integer idProjecto){
        projectoRepository.deleteById(idProjecto);
        return "redirect:/listaProjecto";
    }
}
