package com.webbappgestaoprojectos.service;

import com.webbappgestaoprojectos.model.Permissao;
import com.webbappgestaoprojectos.model.Utilizador;
import com.webbappgestaoprojectos.repository.UtilizadorRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class SSUserDetailsService implements UserDetailsService {
    private UtilizadorRepository utilizadorRepository;

    public SSUserDetailsService(UtilizadorRepository utilizadorRepository){
        this.utilizadorRepository = utilizadorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            Utilizador utilizador = utilizadorRepository.findByUsername(username);
            if(utilizador == null){
                return null;
            }
            return new User(utilizador.getUsername(),
                    utilizador.getPassword(), getAuthorities(utilizador));
        }catch (Exception e){
            throw new UsernameNotFoundException("Utilizador nao encontrado!!!");
        }
    }

    private Set<GrantedAuthority> getAuthorities(Utilizador utilizador){

        Set<GrantedAuthority> authorities = new HashSet<>();
        for(Permissao permissao : utilizador.getPermissao()){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permissao.getDescricao());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }

}
