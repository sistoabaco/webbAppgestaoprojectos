package com.webbappgestaoprojectos.controller;

import com.webbappgestaoprojectos.model.*;
import com.webbappgestaoprojectos.repository.ParceiroRepository;
import com.webbappgestaoprojectos.repository.PermissaoRepository;
import com.webbappgestaoprojectos.repository.ProjectoRepository;
import com.webbappgestaoprojectos.repository.UtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
public class ParceiroController {
    @Autowired
    ParceiroRepository parceiroRepository;
    @Autowired
    ProjectoRepository projectoRepository;
    @Autowired
    PermissaoRepository permissaoRepository;
    @Autowired
    UtilizadorRepository utilizadorRepository;

    @RequestMapping("/listaParceiro")
    public String listaDeParceiros(Model model){
        model.addAttribute("financiador", parceiroRepository.findAll());
        return "lista_parceiro";
    }

    @GetMapping("/salvarParceiro")
    public String salvarParceiro(Model model){
        model.addAttribute("projecto", projectoRepository.findAll());
        model.addAttribute("permissao", permissaoRepository.findAll());
        return "formulario_parceiro";
    }

    @PostMapping(value = "/salvarParceiro")
    public String salvarParceiros(@Valid Parceiro parceiro, @Valid Utilizador u, @RequestParam(value = "projeto", required = true)  Collection <Projecto> proj,
        BindingResult result, @RequestParam(value = "permi", required = true)  Collection <Permissao> role, Model model){

//        System.out.println("role " + role);

        u.setPermissao(role);
        utilizadorRepository.save(u);

        if((!u.getUsername().equals(parceiro.getEmail())) & result.hasErrors()){
            model.addAttribute("erro", "problemas ou username e e-mail diferentes!!!");
            model.addAttribute("projecto", projectoRepository.findAll());
            model.addAttribute("permissao", permissaoRepository.findAll());
            model.addAttribute("parceiro", new Parceiro());
            return"formulario_parceiro";
        }

        parceiro.setUtilizador(u);
        parceiro.setProjecto(proj);

        parceiroRepository.save(parceiro);

        return"redirect:/listaParceiro";
    }
}
