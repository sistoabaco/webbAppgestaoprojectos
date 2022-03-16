package com.webbappgestaoprojectos.controller;

import com.webbappgestaoprojectos.model.*;
import com.webbappgestaoprojectos.repository.ParceiroRepository;
import com.webbappgestaoprojectos.repository.PermissaoRepository;
import com.webbappgestaoprojectos.repository.ProjectoRepository;
import com.webbappgestaoprojectos.repository.UtilizadorRepository;
import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.Encoder;
import java.util.*;

@Controller
public class ParceiroController {
    @Autowired
    ParceiroRepository parceiroRepository;
    @Autowired
    ProjectoRepository projectoRepository;
    @Autowired
    PermissaoRepository permissaoRepository;
    @Autowired
    UtilizadorRepository utilizadorRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @RequestMapping("/listaParceiro")
    public String listaDeParceiros(Model model){
        model.addAttribute("financiador", parceiroRepository.findAll());
        return "lista_parceiro";
    }

    @GetMapping("/salvarParceiro")
    public String salvarParceiro(Model model){
        model.addAttribute("projecto", projectoRepository.findAll());
        model.addAttribute("permissao", permissaoRepository.findAll());
        return "formulario_parceiro";
    }

    @PostMapping(value = "/salvarParceiro")
    public String salvarParceiros(@Valid Parceiro parceiro, @Valid Utilizador u, @RequestParam(value = "pro", required = true)  Collection <Projecto> proj,
        BindingResult result, @RequestParam(value = "permi", required = true)  Collection <Permissao> role, Model model){

//        System.out.println("roleProSize " + role.size());

        u.setPermissao(role);
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        utilizadorRepository.save(u);

        if((!u.getUsername().equals(parceiro.getEmail())) & result.hasErrors()){
            model.addAttribute("erro", "problemas, ou username e e-mail diferentes!!!");
            model.addAttribute("projecto", projectoRepository.findAll());
            model.addAttribute("permissao", permissaoRepository.findAll());
            model.addAttribute("parceiro", new Parceiro());
            return"formulario_parceiro";
        }

        parceiro.setUtilizador(u);
        parceiro.setProjecto(proj);

        parceiroRepository.save(parceiro);

        return"redirect:/listaParceiro";
    }

    @GetMapping("/detalhesParceiro/{username}")
    public String detalhesFuncionario(@PathVariable("username") String username,
                                      Model model){
        model.addAttribute("p", parceiroRepository.findByUtilizador(utilizadorRepository.findByUsername(username)));
        return "detalhes_parceiro";
    }

    @GetMapping("/apagarParceiro/{username}")
    public String apagarParceiro(@PathVariable("username") String user){
        Utilizador utilizador = utilizadorRepository.findByUsername(user);
        Parceiro parceiro = parceiroRepository.findByUtilizador(utilizador);

        parceiroRepository.delete(parceiro);
        utilizadorRepository.delete(utilizador);
        return "redirect:/listaParceiro";
    }

    @GetMapping("/editarParceiro/{idParceiro}")
    public String editFormParceiro(@PathVariable("idParceiro") Integer id){
        System.out.println("entrou: " + id);
//        return "edit_formulario_parceiro";
        return "redirect:/listaParceiro";
    }

}
