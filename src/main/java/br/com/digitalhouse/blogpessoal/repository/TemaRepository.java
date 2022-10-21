package br.com.digitalhouse.blogpessoal.repository;

import br.com.digitalhouse.blogpessoal.model.PostagemModel;
import br.com.digitalhouse.blogpessoal.model.TemaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.List;

@Repository
public interface TemaRepository extends JpaRepository<TemaModel, Long> {
    public List<TemaModel> findAllByDescricaoContainingIgnoreCase(String descricao);
}
