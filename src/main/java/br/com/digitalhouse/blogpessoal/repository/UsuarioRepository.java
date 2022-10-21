package br.com.digitalhouse.blogpessoal.repository;

//consultar sql

import br.com.digitalhouse.blogpessoal.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
//junta spring com jpa

//trazer os metodos relacionados com o jpa
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    //optional: nao deixar que fique nulo

   Optional<UsuarioModel> findByUsuario (String usuario);
    //<o diamante serve para referencia para conseguir adicionar os métodos que vao ser aplicados; direcionar metodos do jpa para esse model >
}
