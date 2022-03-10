package com.webbappgestaoprojectos.controller;

import com.webbappgestaoprojectos.model.Funcionario;
import com.webbappgestaoprojectos.model.Projecto;
import com.webbappgestaoprojectos.model.SolicitacaoTransporte;
import com.webbappgestaoprojectos.model.Utilizador;
import com.webbappgestaoprojectos.repository.FuncionarioRepository;
import com.webbappgestaoprojectos.repository.ProjectoRepository;
import com.webbappgestaoprojectos.repository.SolicitacaoTRepository;
import com.webbappgestaoprojectos.repository.UtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/teamLeader")
    public String teamLeader(){
        return "team_leader";
    }
    @GetMapping("/listaSTransporte")
    public String listarST(Model model){
        model.addAttribute("STransporte", str.findAll());
        return"lista_s_transporte";
    }

    @GetMapping("/salvarST")
    public String salvarST(Model model){

        String s = new UtilizadorController().UtilizadorLogado();
        Utilizador ut = ur.findByUsername(s);
        Funcionario aux = new Funcionario();
        Collection <Funcionario> fList = fr.findAll();

        for (Funcionario f: fList) {
            if (f.getUtilizador() == ut) {
                aux=f;
                break;
            }
        }

        model.addAttribute("projecto", pr.findAll());
        model.addAttribute("funcionario", aux);
        model.addAttribute("solicitacaoTransporte", new SolicitacaoTransporte());
        return"formulario_s_transporte";
    }

    @PostMapping("/salvarST")
    public String salvarST(SolicitacaoTransporte st, @RequestParam(value = "pro", required = true) Projecto proj,
                           Funcionario f, Model model, BindingResult result){

        st.setFuncionario(f);
        st.setProjecto(proj);
        st.setSolitanteResponsavel(f.toString());
        st.setStatus("Pendente");
        str.save(st);

        return"redirect:/listaSTransporte";
    }


    @GetMapping("/editSolTransporte/{idSolicitacaoTransporte}")
    public String editFormSolTransporte(@PathVariable("idSolicitacaoTransporte") Integer idSolicitacaoTransporte,
                                   Model model){
        model.addAttribute("solicitacaoTransporte", str.findById(idSolicitacaoTransporte).get());
        return "formulario_projecto";
    }

    @GetMapping("/deleteSolTransporte/{idSolicitacaoTransporte}")
    public String SolTransporte(@PathVariable("idSolicitacaoTransporte") Integer idSolicitacaoTransporte){
        str.deleteById(idSolicitacaoTransporte);
        return "redirect:/listaSTransporte";
    }
}
