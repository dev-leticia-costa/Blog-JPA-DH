package br.com.digitalhouse.blogpessoal.repository;

import br.com.digitalhouse.blogpessoal.model.PostagemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostagemRepository extends JpaRepository <PostagemModel, Long>{
     List<PostagemModel> findAllByTituloContainingIgnoreCase(String titulo);
    //método pegar tudo que está no banco e trazer
    //so consegue usar o metodo da classe jpa quando faz o repository
    //JOPA TEM METODOS QUE SAO TRZIDOS PARA O RESPOSITORU QUE SAO CHAMADOS NA CLASSE REPOSTITORU
}//GET ALL É UM METODO CRIADO AQUUI, O FINDALL É DO JPA
