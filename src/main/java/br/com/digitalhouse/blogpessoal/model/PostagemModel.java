package br.com.digitalhouse.blogpessoal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Entity //entidade persistente*, cujos objetos podem ser armazenados em um banco de dados relacional
@Table(name = "tb_postagens")//nome da tabela que está associada à entidade
public class PostagemModel {

    @Id// chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY)//  chave primária é gerada automaticamente, por auto-incremento no BD
    private Long id;
    @NotNull
    @Size(min = 5, max = 100)
    private String titulo;

    @NotNull
    @Size(min = 10, max = 500)
    private String texto;



    //--> Usando para entrar no banco data com formatação dia mês e ano....
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")// para ignorar propriedades específicas durante a serialização
    private LocalDate data;

    @ManyToOne //  associação muitos-para-um entre duas entidades
    @JsonIgnoreProperties("postagemTema")// para ignorar propriedades específicas durante a serialização.
    private TemaModel tema;

//---> Getters and Setters: métodos utilizados em POO para acessar e modificar atributos de uma classe encapsulada (atributos privados)
//    atributos privados não pode ser acessados fora da classe sem os métodos acima.
//    Get-> método de acesso
//    Set-> método de modificação, recebe um parâmetro que define o novo valor do atributo
    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getTitulo() {

        return titulo;
    }

    public void setTitulo(String titulo) {

        this.titulo = titulo;
    }

    public String getTexto() {

        return texto;
    }

    public void setTexto(String texto) {

        this.texto = texto;
    }
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public TemaModel getTema() {
        return tema;
    }

    public void setTema(TemaModel tema) {
        this.tema = tema;
    }
}

//*PERSISTÊNCIA: o termo "persistência" se refere à capacidade de manter o estado de uma entidade, geralmente no contexto de um sistema de gerenciamento de banco de dados, de forma que os dados associados à entidade possam ser armazenados, recuperados, atualizados e eventualmente removidos de maneira confiável.
//o termo "persistência" se refere à capacidade de manter o estado de uma entidade, geralmente no contexto de um sistema de gerenciamento de banco de dados, de forma que os dados associados à entidade possam ser armazenados, recuperados, atualizados e eventualmente removidos de maneira confiável.