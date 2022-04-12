package com.webbappgestaoprojectos.controller;

import com.webbappgestaoprojectos.repository.OrdemCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdemDeCompraController {

    @Autowired
    OrdemCompraRepository oc;

    @GetMapping("/ordemCompra")
    public String ordemCompra(){
        return "ordem_compra";
    }

    @GetMapping("/listaOC")
    public String listaOC(Model model){
        model.addAttribute("oc", oc.findAll());
        return "lista_ordem_compra";
    }

    @GetMapping("/salvarOC")
    public String salvarOC(Model model){
        return"formulario_oc";
    }
}
