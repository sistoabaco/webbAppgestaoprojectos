package com.webbappgestaoprojectos.controller;

import com.webbappgestaoprojectos.repository.RequisicaoPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RequisicaoPagamentoController {

    @Autowired
    RequisicaoPagamentoRepository rp;

    @GetMapping("/requisicaoPagamento")
    public String requisicaoPagamento(){
        return "requisicao_pagamento";
    }

    @GetMapping("/listaReqPagamento")
    public String listaRP(Model model){
        model.addAttribute("rp", rp.findAll());
        return "lista_requisicaoP";
    }

    @GetMapping("/salvarReqPagamento")
    public String salvarRP(Model model){
        return "formulario_rp";
    }
}
