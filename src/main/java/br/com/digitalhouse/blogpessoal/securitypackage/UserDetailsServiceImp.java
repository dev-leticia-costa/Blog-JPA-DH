package br.com.digitalhouse.blogpessoal.securitypackage;

import br.com.digitalhouse.blogpessoal.model.UsuarioModel;
import br.com.digitalhouse.blogpessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.Optional;


@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsuarioModel> usuario = userRepository.findByUsuario(username);

        if(usuario.isPresent()) {
            return new UserDetailsImpl(usuario.get());
        } else
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);

    }

    }



