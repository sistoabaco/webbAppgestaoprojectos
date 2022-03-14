package com.webbappgestaoprojectos.controller;

import com.webbappgestaoprojectos.model.TabelaNecessidadeTdR;
import com.webbappgestaoprojectos.model.TermoReferencia;
import com.webbappgestaoprojectos.repository.TdRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Collection;

@Controller
public class TdrController {

    @Autowired
    TdRRepository tdrr;

    @RequestMapping("/listTdR")
    public String listaTdR(Model model){
        model.addAttribute("TdR", tdrr.findAll());
        return"lista_tdr";
    }

    @GetMapping("/salvarTdR")
    public String salvarTdR(){
        return"formulario_tdr";
    }

    @PostMapping("/salvarTdR")
    public String addTdR(TermoReferencia tdr, Collection <TabelaNecessidadeTdR> tn){

        tdr.setDataElaboracao(LocalDate.now());
        return"redirect:/listaTdR";
    }
}
