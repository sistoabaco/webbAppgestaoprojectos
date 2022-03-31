package com.webbappgestaoprojectos.controller;

import com.webbappgestaoprojectos.model.TabelaNecessidadeTdR;
import com.webbappgestaoprojectos.model.TermoReferencia;
import com.webbappgestaoprojectos.repository.FuncionarioRepository;
import com.webbappgestaoprojectos.repository.TNTdRRepository;
import com.webbappgestaoprojectos.repository.TdRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NecessidadeController {
    @Autowired
    TdRRepository tdrr;
    @Autowired
    FuncionarioRepository fr;
    @Autowired
    TNTdRRepository tnr;

    @GetMapping("/listaTN")
    public String listaNecessidade(Model model){
        model.addAttribute("tabN", tnr.findAll());
        return "lista_necessidades";
    }

    @GetMapping("/salvarTN")
    public String salvarTN(Model model){
        model.addAttribute("TdR", tdrr.findAll());
        model.addAttribute("tabN", tnr.findAll());
        return "tabela_necessidades";
    }

    @PostMapping("/salvarTN")
    public String salvarTabN(TabelaNecessidadeTdR tn, TermoReferencia TdR, Model model){
//        TdR.setSaldoTotalActividade(tn.getValorTotal()+TdR.getSaldoTotalActividade());

        tn.setValorTotal(tn.getValorUnitario()*tn.getQtdMaterial()*tn.getQtdDias());

        TdR.setSaldoTotalActividade(TdR.getSaldoTotalActividade() + tn.getValorTotal());
        tdrr.save(TdR);

        tn.setTermoReferencia(TdR);
        tnr.save(tn);

        return "redirect:/salvarTN";
    }
}
