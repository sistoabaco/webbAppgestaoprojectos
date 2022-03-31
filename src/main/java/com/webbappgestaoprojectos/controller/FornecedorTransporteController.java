package com.webbappgestaoprojectos.controller;

import com.webbappgestaoprojectos.model.FornecedorTransporte;
import com.webbappgestaoprojectos.repository.FornecedorTransporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FornecedorTransporteController {

    @Autowired
    FornecedorTransporteRepository fornecedorTransporteRepository;

    @GetMapping("/fornecedorTransporte")
    public String listaFT(Model model){
        model.addAttribute("fTransporte", fornecedorTransporteRepository.findAll());
        return "lista_ft";
    }

    @GetMapping("/salvarFornecdorT")
    public String salvarFornecedorT(){
        return "fornecedor_transporte";
    }

    @PostMapping("/salvarFornecdorT")
    public String salvarFTransporte(FornecedorTransporte ft){
        fornecedorTransporteRepository.save(ft);
        return "redirect:/fornecedorTransporte";
    }
}
