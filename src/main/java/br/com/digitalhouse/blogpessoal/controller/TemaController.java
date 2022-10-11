package br.com.digitalhouse.blogpessoal.controller;

import br.com.digitalhouse.blogpessoal.model.TemaModel;
import br.com.digitalhouse.blogpessoal.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/tema")

public class TemaController {

    @Autowired
    private TemaRepository temaRepository;

    @GetMapping("/{id}")
    public ResponseEntity<TemaModel> getById(@PathVariable Long id) {
        return temaRepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                //{pegar a variavel que vai ser digitada por alguem}
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<TemaModel>> getByName(@PathVariable String nome) {
    return ResponseEntity.ok(temaRepository.findAllByDescricaoContainingIgnoreCase(nome));
    }
     @PostMapping
     //adicionando um novo tema na nossa tabela
    public ResponseEntity<TemaModel> post(@RequestBody TemaModel tema) {
        return ResponseEntity.status(HttpStatus.CREATED)
                //STATUS DE QUE FOI CRIADO
                .body(temaRepository.save(tema));
     }
     @PutMapping
    public ResponseEntity<TemaModel> put(@RequestBody TemaModel tema){
        return ResponseEntity.status(HttpStatus.CREATED)
                //STATUS DE QUE FOI CRIADO
               .body(temaRepository.save(tema));
     }

    //{pegar a variavel que vai ser digitada por alguem}
}
//lambda transofmra a entidade em string