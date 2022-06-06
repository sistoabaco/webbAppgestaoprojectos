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
import java.sql.Date;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/users")

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
    @Autowired
    ParceiroRepository parceiroRepository;

    @RequestMapping(value = "/listaFuncionar io", method = RequestMethod.GET)
    public List<Funcionario> listaFuncionario(Model model){
        return fr.findAll();
    }

    @GetMapping("/salvarFuncionario")
    public String adicionarFuncionario(Model model){
        model.addAttribute("permissao", pr.findAll());
        model.addAttribute("categoria", cr.findAll());
        model.addAttribute("projecto", projectoRepository.findAll());
        model.addAttribute("funcionario", new Funcionario());
        return "adicionar_funcionario";
    }

    @PostMapping("/salvarFuncionario")
    public String adicionarFuncionario(@Valid Funcionario f, @Valid Utilizador u, @RequestParam(value = "pro", required = true)  Collection <Projecto> proj,
    Categoria cat, BindingResult result, @RequestParam(value = "permi", required = true) Collection<Permissao> role, Model model,
        @RequestParam(value="dataNascimento", required = true) String dataN, @RequestParam(value="dataInicio", required = true) String dataI,
                                       @RequestParam(value="dataNascimento",required = true) String dataF){
//        model.addAttribute("erro", "erro ao salvar funcionario");

        if (u.getUsername() .equals(ur.findByUsername(u.getUsername()))){
            model.addAttribute("erro", "username existente!!! informe outro username");
            return "adicionar_funcionario";
        }

        u.setPermissao(role);
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        ur.save(u);

        f.setCategoria(cat);
        f.setProjecto(proj);
        f.setUtilizador(u);

        f.setDataNascimento(Date.valueOf(dataN));
        f.setDataFim(Date.valueOf(dataF));
        f.setDataInicio(Date.valueOf(dataI));

        fr.save(f);

        return "redirect:/listaFuncionario";
    }

    @GetMapping("/editarFuncionario/{idFuncionario}")
    public String editFormAdFuncionario(@PathVariable("idFuncionario") Integer id,
                                        Model model){
        model.addAttribute("funcionario", fr.findById(id).get());
        model.addAttribute("permissao", pr.findAll());
        model.addAttribute("categoria", cr.findAll());
        model.addAttribute("projecto", projectoRepository.findAll());

        return "edit_formulario_adic_funcionario";
    }

//    @PostMapping("/salvarEditFuncionario/{idFuncionario}")
//    public String editFuncionario(@PathVariable("idFuncionario") Integer id, Model model){
//
//        if (u.getUsername() .equals(ur.findByUsername(u.getUsername()))){
//            model.addAttribute("erro", "username existente!!! informe outro username");
//            return "adicionar_funcionario";
//        }
//
//        u.setPermissao(role);
//        u.setPassword(passwordEncoder.encode(u.getPassword()));
//        ur.save(u);
//
//        f.setCategoria(cat);
//        f.setProjecto(proj);
//        f.setUtilizador(u);
//
//        fr.save(f);
//
//        return "redirect:/listaFuncionario";
//    }

    @GetMapping("/apagarFuncionario/{idFuncionario}")
    public String apagarFuncionario(@PathVariable("idFuncionario") Integer idFuncionario){

        Funcionario funcionario = fr.findById(idFuncionario).get();
        Utilizador utilizador = ur.findByUsername(funcionario.getUtilizador().getUsername());

        if(utilizador.getUsername().equalsIgnoreCase("admin@domain.com")){
            fr.delete(funcionario);
            ur.delete(utilizador);
            return "redirect:/logout";
        }

        fr.delete(funcionario);
        ur.delete(utilizador);

        return "redirect:/listaFuncionario";
    }

    @GetMapping("/detalhesFuncionario/{username}")
    public String detalhesFuncionario(@PathVariable("username") String username,
                                        Model model){
            model.addAttribute("f", fr.findByUtilizador(ur.findByUsername(username)));
            return "detalhes_funcionario";
    }
}
