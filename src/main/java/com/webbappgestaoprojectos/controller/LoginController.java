package com.webbappgestaoprojectos.controller;

import com.webbappgestaoprojectos.model.Funcionario;
import com.webbappgestaoprojectos.model.Utilizador;
import com.webbappgestaoprojectos.repository.FuncionarioRepository;
import com.webbappgestaoprojectos.repository.UtilizadorRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping ("/login")
    public String login(){
        return"login";
    }

    @RequestMapping ("/paginaSegura")
    public String paginaSegura(){
        return"pagina_segura";
    }

    @RequestMapping ("/gestorFinanceiro")
    public String paginaGestorFinanceira(){
        return"gestor_financeiro";
    }

}
