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

    @GetMapping("/listaSTransporte")
    public String listarST(Model model){
        model.addAttribute("STransporte", str.findAll());
        return"lista_s_transporte";
    }

    @GetMapping("/solicitacaoTransporte")
    public String MenuST(Model model){
        String s = new UtilizadorController().UtilizadorLogado();//dados de sessao
        Utilizador ut = ur.findByUsername(s);//utilizador logado

        Collection <SolicitacaoTransporte> sTList = str.findByStatus("Pendente");
        model.addAttribute("STransporteC", sTList);

        Collection <SolicitacaoTransporte> logisticList = str.findByCoordenadorST();
        model.addAttribute("transporteList", logisticList);

        return"solicitacao_transporte";
    }

    @RequestMapping(value = "/coordenador", method = RequestMethod.GET)
    public String coordenador(Model model){

        model.addAttribute("transporteList", str.findByCoordenadorST());
        return "coordenador_area";

    }

    @RequestMapping(value = "/logistico", method = RequestMethod.GET)
    public String logisticoModel(Model model){

        model.addAttribute("transporteList", str.findByLogisticoST());
        return "logistico_area";
    }

    @RequestMapping("/teamLeader")
    public String teamLeader(){
        return "team_leader_area";
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

        if( f.getCategoria().getDescricao().equalsIgnoreCase("COORDENADOR")){
            st.setCoordenador(f.toString());
            st.setDataAprovacaoCoordenador(LocalDate.now());
            str.save(st);
            return"redirect:/coordenador";
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

    @GetMapping("/aprovar/{idSolicitacaoTransporte}")
    public String aprovarOuRejeitarST(@PathVariable("idSolicitacaoTransporte") Integer idST, Model model){
        model.addAttribute("STransporte", str.findById(idST).get());
        return"aprovar_s_transporte";
    }

    @PostMapping("/aprovar/{idSolicitacaoTransporte}")
    public String aprovarOuRejeitarSTr(@PathVariable("idSolicitacaoTransporte") Integer idST,
    @RequestParam(value = "statu", required = true) String status){
        char piloto  = 'k';

        String s = new UtilizadorController().UtilizadorLogado();//dados de sessao
        Utilizador ut = ur.findByUsername(s);//utilizador logado
        SolicitacaoTransporte st = str.findById(idST).get();

        if(fr.findByUtilizador(ut).getCategoria().getDescricao().equalsIgnoreCase("COORDENADOR") ||
        fr.findByUtilizador(ut).getCategoria().getDescricao().equalsIgnoreCase("ADMIN")) {
            st.setCoordenador(fr.findByUtilizador(ut).toString());
            st.setDataAprovacaoCoordenador(LocalDate.now());
            piloto = 'c';
        }else if(fr.findByUtilizador(ut).getCategoria().getDescricao().equalsIgnoreCase("LOGISTICO") ||
        fr.findByUtilizador(ut).getCategoria().getDescricao().equalsIgnoreCase("ADMIN")) {
            st.setLogistico(fr.findByUtilizador(ut).toString());
            st.setDataAprovacaoLogistico(LocalDate.now());
            st.setStatus("Aprovado");
            piloto = 'l';
        }

        if(piloto == 'c') {
            str.save(st);
            return "redirect:/coordenador";
        }

        if(piloto == 'l') {
            str.save(st);
            return "redirect:/logistico";
        }

        return"redirect:/detalheST/{idSolicitacaoTransporte}";
    }

    @GetMapping("/detalheST/{idSolicitacaoTransporte}")
    public String detalheST(@PathVariable("idSolicitacaoTransporte") Integer idST, Model model){
        model.addAttribute("STransporte", str.findById(idST).get());
        return"detalhes_sol_transporte";
    }
}