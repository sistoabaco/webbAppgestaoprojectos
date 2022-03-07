package com.webbappgestaoprojectos.controller;

import com.webbappgestaoprojectos.repository.FuncionarioRepository;
import com.webbappgestaoprojectos.repository.ProjectoRepository;
import com.webbappgestaoprojectos.repository.SolicitacaoTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SolicitacaoTController {

    @Autowired
    SolicitacaoTRepository st;
    @Autowired
    ProjectoRepository pr;
    @Autowired
    FuncionarioRepository fr;

    @GetMapping("/listaSTransporte")
    public String listarST(Model model){
        model.addAttribute("ST", st.findAll());
        return"listaST";
    }

    @GetMapping("/salvarST")
    public String salvarST(Model model){
        model.addAttribute("projecto", pr.findAll());
        return"formulario_s_transporte";
    }

    @PostMapping("salvarST")
    public String salvarST(Model model, BindingResult result){
        return"redirect:/listaSTransporte";
    }
}
