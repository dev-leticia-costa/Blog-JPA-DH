package br.com.digitalhouse.blogpessoal.model;
//nao é uma entidade
//nao tem id, só retorna informações
public class UsuarioLoginModel {

    private String nome;
    private String usuario;
    private String token;
    private String password;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //liberação para fazer postagem, por exemplo
    //ver getter and setter com parametro/ construtor
}
