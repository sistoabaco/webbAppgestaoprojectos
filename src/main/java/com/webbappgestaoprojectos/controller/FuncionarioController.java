package com.webbappgestaoprojectos.controller;

import com.webbappgestaoprojectos.model.*;
import com.webbappgestaoprojectos.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Collection;

@Controller
public class FuncionarioController {

    @Autowired
    UtilizadorRepository ur;
    @Autowired
    FuncionarioRepository fr;
    @Autowired
    PermissaoRepository pr;
    @Autowired
    CategoriaRepository cr;
    @Autowired
    ProjectoRepository projectoRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @RequestMapping(value = "/listaFuncionario", method = RequestMethod.GET)
    public String listaFuncionario(Model model){
        model.addAttribute("funcionario", fr.findAll());
        return "lista_funcionario";
    }

    @GetMapping("/salvarFuncionario")
    public String adicionarFuncionario(Model model){
        model.addAttribute("permissao", pr.findAll());
        model.addAttribute("categoria", cr.findAll());
        model.addAttribute("projecto", projectoRepository.findAll());
        return "adicionar_funcionario";
    }

    @PostMapping("/salvarFuncionario")
    public String adicionarFuncionario(@Valid Funcionario f, @Valid Utilizador u, @RequestParam(value = "projeto", required = true)  Collection <Projecto> proj,
    Categoria cat, BindingResult result, @RequestParam(value = "permi", required = true) Collection<Permissao> role, Model model){

        System.out.println("Chega aqui!!!");
//        model.addAttribute("erro", "erro ao salvar funcionario");


        if (u.getUsername() .equals(ur.findByUsername(u.getUsername()))){
            model.addAttribute("erro", "username existente!!! informe outro username");
            return "adicionar_funcionario";
        }

        u.setPermissao(role);
        ur.save(u);

        f.setCategoria(cat);
        f.setProjecto(proj);
        f.setUtilizador(u);

        fr.save(f);

        return "redirect:/listaFuncionario";
    }

}
