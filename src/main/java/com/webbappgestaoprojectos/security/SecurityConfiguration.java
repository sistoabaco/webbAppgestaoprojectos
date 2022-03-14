package com.webbappgestaoprojectos.security;

import com.webbappgestaoprojectos.model.Utilizador;
import com.webbappgestaoprojectos.repository.UtilizadorRepository;
import com.webbappgestaoprojectos.service.SSUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    @Bean
    public static BCryptPasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}

    @Autowired
    SSUserDetailsService userDetailsService;
    @Autowired
    UtilizadorRepository utilizadorRepository;

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception{
        return new SSUserDetailsService(utilizadorRepository);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/h2", "/","/projectos", "/actividades", "/apoiadores", "/parceiros","/sobre").permitAll()
                .antMatchers( "/gestorFinanceiro", "/salvarFuncionario","/salvarParceiro", "/salvarProjecto").access("hasAnyAuthority('P_GESTOR FINANCEIRO','ADMIN')")
                .antMatchers( "/listaUtilizador").access("hasAuthority('ADMIN')")
                .antMatchers( "/salvarST").access("hasAnyAuthority('P_TEAM LEADER', 'P_COORDENADOR')")
                //Para qualquer requisiÃ§Ã£o (anyRequest) Ã© preciso estar (anyRequest)
                .anyRequest()
                // autenticado (authenticated)
                .authenticated()

                // Aqui dizemos que temos uma pÃ¡gina customizada.
                .and().formLogin().loginPage("/login").permitAll()
                // Mesmo sendo a pÃ¡gina de login, precisamos avisar
                // ao Spring Security para liberar o acesso a ela.
                .defaultSuccessUrl("/paginaSegura")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login").permitAll()
                .and()
                .httpBasic();
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
//        builder
////                .inMemoryAuthentication()
////                .withUser("sabaco@unilurio.ac.mz").password(passwordEncoder().encode("12345"))
////                .authorities("ADMIN")
////                .and()
////                .withUser("pmarques@unilurio.ac.mz").password(passwordEncoder().encode("54321"))
////                .authorities("USER");
        builder.userDetailsService(userDetailsServiceBean())
                .passwordEncoder(passwordEncoder());
    }
}
