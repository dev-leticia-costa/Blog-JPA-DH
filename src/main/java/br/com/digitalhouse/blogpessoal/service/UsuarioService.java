package br.com.digitalhouse.blogpessoal.service;

import br.com.digitalhouse.blogpessoal.model.UsuarioLoginModel;
import br.com.digitalhouse.blogpessoal.model.UsuarioModel;
import br.com.digitalhouse.blogpessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.binary.Base64;
import java.nio.charset.Charset;
//import java.util.Base64;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioModel CadastrarUsuario(UsuarioModel usuario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaEncoder = encoder.encode(usuario.getSenha());
        usuario.setSenha(senhaEncoder);
        return repository.save(usuario);
    }

    public Optional<UsuarioLoginModel> Logar(Optional<UsuarioLoginModel> user) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<UsuarioModel> usuario = repository.findByUsuario(user.get().getUsuario());

        if (usuario.isPresent()) {

                if (encoder.matches(user.get().getPassword(), usuario.get().getSenha())) {

                String auth = user.get().getUsuario() + ":" + user.get().getPassword();

                byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));

                String authHeader = "Basic " + new String(encodedAuth);

                user.get().setToken(authHeader);
                user.get().setNome(usuario.get().getUsuario());

                return user;
            }
        }
        return null;
    }
}

        //comparando a senha do login com a senha do usuario, se elas batem com o que esta no bd
        //transformando as senhas em strings
        //colocando a senha dentro de um array de bytes
                //colocar o array dentro de uma outra string (pq byte é memoria, precisa ser algo tangivel- caracteres)
        //aquilo vai ser o token do momento


//implementar cadastro e login