package com.webbappgestaoprojectos.security;

import com.webbappgestaoprojectos.model.*;
import com.webbappgestaoprojectos.repository.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner{
    @Autowired
    UtilizadorRepository utilizadorRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    PermissaoRepository pr;
    @Autowired
    ProjectoRepository projR;
    @Autowired
    ParceiroRepository paR;
    @Autowired
    CategoriaRepository cr;

    @Override
    public void run(String...args) throws Exception {
        pr.save(new Permissao("ADMIN"));
        pr.save(new Permissao("P_PARCEIRO"));
        pr.save(new Permissao("P_TEAM LEADER"));
        pr.save(new Permissao("P_COORDENADOR"));
        pr.save(new Permissao("P_OFICIAL DE MEAL"));
        pr.save(new Permissao("P_GESTOR DE PROJECTOS"));
        pr.save(new Permissao("P_DIRECTOR"));
        pr.save(new Permissao("P_GESTOR FINANCEIRO"));
        pr.save(new Permissao("P_CONTABILISTA"));
        pr.save(new Permissao("P_OFICIAL DE LOGISTICA"));
        pr.save(new Permissao("P_ASSISTENTE DE LOGISTICA"));
        pr.save(new Permissao("P_SECRETARIA"));
        pr.save(new Permissao("P_FIEL DE ARMAZEM"));
        pr.save(new Permissao("P_TECNICOS DO CAMPO"));

        Permissao adminPermissao = pr.findByRole("ADMIN");
        Permissao parPermissao = pr.findByRole("P_PARCEIRO");
        Permissao financeiroP = pr.findByRole("P_GESTOR FINANCEIRO");

        Utilizador utilizador =
                new Utilizador("sabaco@unilurio.ac.mz", passwordEncoder.encode("12345"));
        utilizador.setPermissao(Arrays.asList(adminPermissao, financeiroP,parPermissao ));
        utilizadorRepository.save(utilizador);

//        Utilizador u = new Utilizador("pmarques@unilurio.ac.mz", passwordEncoder.encode("54321"));
//        u.setPermissao(Arrays.asList(userPermissao));
//        utilizadorRepository.save(u);
//
        projR.save(new Projecto("BHA", "Activo", 12000000.0, "Chiure e Ancuabe",
                "2020-08-01", "2020-10-01", "USD",8276626.0));

        Utilizador uPar = new Utilizador("usaid@gmail.com", passwordEncoder.encode("zxcvb"));
        uPar.setPermissao(Arrays.asList(parPermissao));
        utilizadorRepository.save(uPar);

        Parceiro parceiro = new Parceiro("USAID","12123122","RUA DAS FLORES",
                "usaid@gmail.com",uPar);

        Projecto p = projR.findByName("BHA");

        parceiro.setProjecto( Arrays.asList(p));
        paR.save(parceiro);


         cr.save (new Categoria("TEAM LEADER", 30000.0));
         cr.save(new Categoria("COORDENADOR", 80000.0));
         cr.save(new Categoria("OFICIAL DE MEAL", 30000.0));
         cr.save(new Categoria("GESTOR FINANCEIRO", 135000.0));
//       cr.sava( new Categoria("GESTOR DE PROGRAMAS", 150000.0));
         cr.save(new Categoria("DIRECTOR", 200000.0));
//        Categoria c7 = new Categoria("CONTABILISTA", 30000.0);
//        Categoria c8 = new Categoria("OFICIAL DE LOGISTICA", 50000.0);
//        Categoria c9 = new Categoria("ASSISTENTE DE LOGISTICA", 30000.0);
//        Categoria c10 = new Categoria("SECRETARIA", 30000.0);
//        Categoria c11 = new Categoria("FIEL DE ARMAZEM", 30000.0);
//        Categoria c12 = new Categoria("OUTROS", 50000.0);
    }

}
