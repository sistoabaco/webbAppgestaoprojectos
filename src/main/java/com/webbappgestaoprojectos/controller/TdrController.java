package com.webbappgestaoprojectos.controller;

import com.webbappgestaoprojectos.model.*;
import com.webbappgestaoprojectos.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

@Controller
public class TdrController {

    @Autowired
    TdRRepository tdrr;
    @Autowired
    SolicitacaoTRepository str;
    @Autowired
    ProjectoRepository pr;
    @Autowired
    TNTdRRepository tblr;
    @Autowired
    FuncionarioRepository fr;
    @Autowired
    UtilizadorRepository ur;

    @RequestMapping("/termoReferencia")
    public String TdR(Model model){
        model.addAttribute("termoR", tdrr.findAll());
        return"termo_referencia";
    }

    @GetMapping("/listaTdR")
    public String listaTdR(Model model){
        model.addAttribute("TermoR", tdrr.findAll());
        return"lista_tdr";
    }

    @GetMapping("/salvarTdR")
    public String salvarTdR(Model model){
        String s = new UtilizadorController().UtilizadorLogado();//dados de sessao
        Utilizador ut = ur.findByUsername(s);//utilizador logado

        model.addAttribute("solT", str.findByLogisticoST()); //st aprovado por todos
        return"formulario_tdr";
    }

    @PostMapping("/salvarTdR")
    public String addTdR(TermoReferencia tdr, SolicitacaoTransporte st, Model model,
                         BindingResult result){

        String s = new UtilizadorController().UtilizadorLogado();//dados de sessao
        Utilizador ut = ur.findByUsername(s);//utilizador logado

        tdr.setElaboradoPor(fr.findByUtilizador(ut).toString());
        tdr.setDataElaboracao(LocalDate.now());
        tdr.setCoordenador(st.getCoordenador());

        if(fr.findByUtilizador(ut).getCategoria().getDescricao()
                .equalsIgnoreCase("COORDENADOR")){
            tdr.setAprovadoPor(fr.findByUtilizador(ut).toString());
            tdr.setDataAprovacao(LocalDate.now());
            tdr.setStatus("Aprovado");

        }else {
            tdr.setStatus("Pendente");
        }

        tdr.setSolicitacaoTransporte(st);
        tdr.setProjecto(Arrays.asList(st.getProjecto()));
        tdr.setFuncionario(fr.findByUtilizador(ut));

        tdrr.save(tdr);
        return"redirect:/salvarTN";
    }

    @GetMapping("/aprovarTdR/{idTermoReferencia}")
    public String aprovarOuRejeitarTdR(@PathVariable("idTermoReferencia") Integer idTdR, Model model){
        model.addAttribute("termoR", tdrr.findById(idTdR).get());
        return"aprovar_tdr";
    }

    @PostMapping("/aprovarTdR/{idTermoReferencia}")
    public String aprovarOuRejeitarTdR(@PathVariable("idTermoReferencia") Integer idTdR,
                            @RequestParam(value = "statu", required = true) String status){

        String s = new UtilizadorController().UtilizadorLogado();//dados de sessao
        Utilizador ut = ur.findByUsername(s);//utilizador logado
        TermoReferencia tdr = tdrr.findById(idTdR).get();

        tdr.setAprovadoPor(fr.findByUtilizador(ut).toString());
        tdr.setDataAprovacao(LocalDate.now());
        tdr.setStatus("Aprovado");

        tdrr.save(tdr);
        return "redirect:/listaTdR";
    }
}
