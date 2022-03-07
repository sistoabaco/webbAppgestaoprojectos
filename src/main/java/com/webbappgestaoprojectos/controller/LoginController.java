package com.webbappgestaoprojectos.controller;

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
}
