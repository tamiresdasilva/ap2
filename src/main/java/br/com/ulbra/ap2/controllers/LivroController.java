package br.com.ulbra.ap2.controllers;

import br.com.ulbra.ap2.model.Livro;
import br.com.ulbra.ap2.services.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrar(@RequestBody Livro livro){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(livro.getId()).toUri();
        return  ResponseEntity.created(uri).body(this.livroService.cadastrar(livro));
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listarTodos(){
        return ResponseEntity.ok()
                .body(this.livroService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> consultarPorId(@PathVariable int id){
        return  ResponseEntity.ok().body(this.livroService.consultarPorId(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@RequestBody Livro livro, @PathVariable int id){
        Livro livroAtualizado = this.livroService.atualizar(livro, id);
        return ResponseEntity.ok().body(livroAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id){
        this.livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
