package br.com.digitalhouse.blogpessoal.model;


import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    private String usuario;
    @NotNull
    @Size(min = 3, max = 100)
    private String nome;
    @NotNull
    @Size(min = 6, max = 100)
    private String senha;
    //por enquanto deixar com 100 no maximo porque a criptografia é grande

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {

        return usuario;
    }

    public void setUsuario(String usuario) {

        this.usuario = usuario;
    }

//get e set na senha tambem porque as aplicações vao precisar da senha para acessar
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {

        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
