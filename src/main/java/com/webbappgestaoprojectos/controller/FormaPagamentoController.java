package com.webbappgestaoprojectos.controller;

import com.webbappgestaoprojectos.model.FormaPagamento;
import com.webbappgestaoprojectos.model.FornecedorTransporte;
import com.webbappgestaoprojectos.model.RequisicaoPagamento;
import com.webbappgestaoprojectos.repository.FormapagamentoRepository;
import com.webbappgestaoprojectos.repository.FornecedorTransporteRepository;
import com.webbappgestaoprojectos.repository.RequisicaoPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormaPagamentoController {

    @Autowired
    FormapagamentoRepository fpr;
    @Autowired
    RequisicaoPagamentoRepository rpr;
    @Autowired
    FornecedorTransporteRepository ftr;

    @GetMapping("/salvarFP")
    public String salvarFP(Model model){
        model.addAttribute("reqPagamento", rpr.findAll());
        model.addAttribute("beneficiarios", ftr.findAll());
        return "forma_pagamento";
    }

    @PostMapping("/salvarFP")
    public String salvarFormaPagamento(FormaPagamento fp, RequisicaoPagamento rp, FornecedorTransporte ft){

        fp.setFornecedorTransporte(ft);
        fp.setRequisicaoPagamento(rp);
        fpr.save(fp);
        return "redirect:/listaReqPagamento";
    }
}
