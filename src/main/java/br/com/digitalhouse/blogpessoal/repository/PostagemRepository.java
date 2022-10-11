package br.com.digitalhouse.blogpessoal.repository;

import br.com.digitalhouse.blogpessoal.model.PostagemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostagemRepository extends JpaRepository <PostagemModel, Long>{
    public List<PostagemModel> findAllByTituloContainingIgnoreCase(String titulo);
}
