package br.com.digitalhouse.blogpessoal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_tema")
public class TemaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String descricao;

    @OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
    //mapeamento = ao tema que for passado como parametro
    //cascata:
    @JsonIgnoreProperties("tema")
    private List<PostagemModel> temaPostagem;

    public Long getId() {
        return id;
    }


}
