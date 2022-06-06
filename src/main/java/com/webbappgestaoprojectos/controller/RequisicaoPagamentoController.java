package com.webbappgestaoprojectos.controller;

import com.webbappgestaoprojectos.model.RequisicaoPagamento;
import com.webbappgestaoprojectos.model.TermoReferencia;
import com.webbappgestaoprojectos.model.Utilizador;
import com.webbappgestaoprojectos.repository.FuncionarioRepository;
import com.webbappgestaoprojectos.repository.RequisicaoPagamentoRepository;
import com.webbappgestaoprojectos.repository.TdRRepository;
import com.webbappgestaoprojectos.repository.UtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class RequisicaoPagamentoController {

    @Autowired
    RequisicaoPagamentoRepository rpr;
    @Autowired
    TdRRepository tdr;
    @Autowired
    UtilizadorRepository ur;
    @Autowired
    FuncionarioRepository fr;

    @GetMapping("/requisicaoPagamento")
    public String requisicaoPagamento(){
        return "requisicao_pagamento";
    }

    @GetMapping("/listaReqPagamento")
    public String listaRP(Model model){
        model.addAttribute("reqP", rpr.findAll());
        return "lista_rp";
    }

    @GetMapping("/salvarReqPagamento")
    public String salvarRP(Model model){
        model.addAttribute("termoRef", tdr.findAll());
        return "formulario_rp";
    }
    @PostMapping("/salvarReqPagamento")
    public String salvarReqPagamento(TermoReferencia tdr, RequisicaoPagamento rp){
        String s = new UtilizadorController().UtilizadorLogado();//dados de sessao
        Utilizador ut = ur.findByUsername(s);//utilizador logado

        rp.setPreparadoPor(fr.findByUtilizador(ut).toString());
        rp.setDataPreparadoPor(LocalDate.now());
        rp.setProjecto(tdr.getProjecto().toString());
        rp.setTermoReferencia(tdr);

        rpr.save(rp);
        return "forma_pagamento";
    }
}
