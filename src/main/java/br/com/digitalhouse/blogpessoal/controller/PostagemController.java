package br.com.digitalhouse.blogpessoal.controller;

import br.com.digitalhouse.blogpessoal.model.PostagemModel;
import br.com.digitalhouse.blogpessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagens")
//define a rota
@CrossOrigin("*")
public class PostagemController {
    @Autowired
    private PostagemRepository repository;

    //buscar na url o primeiro método
    @GetMapping
    public ResponseEntity<List<PostagemModel>> GetAll(){
        return ResponseEntity.ok(repository.findAll());
    }

   @PostMapping
    public ResponseEntity<PostagemModel> post(@RequestBody PostagemModel postagem){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));

   }
//
//    @PutMapping

//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//       repository.deleteById(id);
//    }
}