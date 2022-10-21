package br.com.digitalhouse.blogpessoal.controller;

import br.com.digitalhouse.blogpessoal.model.PostagemModel;
import br.com.digitalhouse.blogpessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/postagens")
//define a rota
@CrossOrigin("*")
public class PostagemController {
    @Autowired//INDICA QUE VAI SER A CAMADA DE PERSISTENCIA DO BANCO, ENCONTRAR, MOSTARR
    private PostagemRepository repository;

    //buscar na url o primeiro método
    //controller backend com front end
    @GetMapping
    public ResponseEntity<List<PostagemModel>> getAll() {

        return ResponseEntity.ok(repository.findAll());
    }
        @GetMapping ("/{id}")
        public ResponseEntity<PostagemModel> getById(@PathVariable Long id){
            return repository.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound()
                            .build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<PostagemModel>> getByTitulo(@PathVariable String titulo){
        return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
    }

    @PostMapping
    public ResponseEntity<PostagemModel> post(@RequestBody PostagemModel postagem){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(repository.save(postagem));
    }//GRAVAR NO DB

    @PutMapping
    public ResponseEntity<PostagemModel> put(@RequestBody PostagemModel postagem){
        return ResponseEntity.status(HttpStatus.OK)
                .body(repository.save(postagem));
    }//ATUALIZAÇÃO: passar os atributos para salvar (id, titulo, texto data)
    //requestbod: solicita o corpo

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
