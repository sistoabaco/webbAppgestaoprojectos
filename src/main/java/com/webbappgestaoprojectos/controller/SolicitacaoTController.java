package com.webbappgestaoprojectos.controller;

import com.webbappgestaoprojectos.model.*;
import com.webbappgestaoprojectos.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;

@Controller
public class SolicitacaoTController {

    @Autowired
    SolicitacaoTRepository str;
    @Autowired
    ProjectoRepository pr;
    @Autowired
    FuncionarioRepository fr;
    @Autowired
    UtilizadorRepository ur;

    @RequestMapping(value = "/coordenador", method = RequestMethod.GET)
    public String coordenador(Model model){
        String s = new UtilizadorController().UtilizadorLogado();//dados de sessao
        Utilizador ut = ur.findByUsername(s);//utilizador logado
        Collection <SolicitacaoTransporte> sTList = str.findByStatus("Pendente");

        model.addAttribute("STransporteC", sTList);
        return "coordenador_area";
    }

    @RequestMapping(value = "/logistico", method = RequestMethod.GET)
    public String logistico(Model model){
        String s = new UtilizadorController().UtilizadorLogado();//dados de sessao
        Utilizador ut = ur.findByUsername(s);//utilizador logado
        Collection <SolicitacaoTransporte> coordenadorList = str.findByCoordenadorST();

        model.addAttribute("transporteList", coordenadorList);
        return "logistico_area";
    }

    @RequestMapping("/teamLeader")
    public String teamLeader(){
        return "team_leader_area";
    }

    @GetMapping("/listaSTransporte")
    public String listarST(Model model){
        model.addAttribute("STransporte", str.findAll());
        return"lista_s_transporte";
    }

    @GetMapping("/salvarST")
    public String salvarST(Model model){
        String s = new UtilizadorController().UtilizadorLogado();//dados de sessao
        Utilizador ut = ur.findByUsername(s);//utilizador logado

        model.addAttribute("projecto", pr.findAll());
        model.addAttribute("funcionarioL", fr.findByUtilizador(ut));
        model.addAttribute("solicitacaoTransporte", new SolicitacaoTransporte());
        return"formulario_s_transporte";
    }

    @PostMapping("/salvarST")
    public String salvarST(SolicitacaoTransporte st, @RequestParam(value = "pro", required = true) Projecto proj,
                           Funcionario f, Model model, BindingResult result){

        st.setFuncionario(f);
        st.setProjecto(proj);
        st.setSolicitanteResponsavel(f.toString());
        st.setStatus("Pendente");

        if(f.getCategoria().equals("coordenador")){
            st.setCoordenador(f.toString());
            st.setDataAprovacaoCoordenador(LocalDate.now());
            str.save(st);
            return"coordenador_area";
        }

        str.save(st);
        return"redirect:/listaSTransporte";
    }

    @GetMapping("/editSolTransporte/{idSolicitacaoTransporte}")
    public String editFormSolTransporte(@PathVariable("idSolicitacaoTransporte") Integer idSolicitacaoTransporte,
                                   Model model){
        model.addAttribute("solicitacaoTransporte", str.findById(idSolicitacaoTransporte).get());
        String s = new UtilizadorController().UtilizadorLogado();//dados de sessao
        Utilizador ut = ur.findByUsername(s);//utilizador logado

        model.addAttribute("projecto", pr.findAll());
        model.addAttribute("funcionarioL", fr.findByUtilizador(ut));
        return "edit_formulario_Sol_transporte";
    }

    @GetMapping("/deleteSolTransporte/{idSolicitacaoTransporte}")
    public String deleteSolTransporte(@PathVariable("idSolicitacaoTransporte") Integer idSolicitacaoTransporte){
        str.deleteById(idSolicitacaoTransporte);
        return "redirect:/listaSTransporte";
    }

    @GetMapping("/detalheST/{idSolicitacaoTransporte}")
    public String detalheST(@PathVariable("idSolicitacaoTransporte") Integer idST, Model model){
        model.addAttribute("STransporte", str.findById(idST).get());
        return"detalhes_sol_transporte";
    }

    @PostMapping("/detalheST/{idSolicitacaoTransporte}")
    public String detalheSTr(@PathVariable("idSolicitacaoTransporte") Integer idST,
    @RequestParam(value = "statu", required = true) String status){

        String s = new UtilizadorController().UtilizadorLogado();//dados de sessao
        Utilizador ut = ur.findByUsername(s);//utilizador logado

        SolicitacaoTransporte st = str.findById(idST).get();
        st.setCoordenador(fr.findByUtilizador(ut).toString());
        st.setDataAprovacaoCoordenador(LocalDate.now());
        str.save(st);
        return"redirect:/coordenador";
    }
}