package br.com.ulbra.ap2.repositories;

import br.com.ulbra.ap2.model.Livro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LivroRepository {
    List<Livro> livros = new ArrayList<>();

    public LivroRepository() {
        livros.add(new Livro(1, "Livro 1", "Autor 1", "Editora 1", 100, 2019));
        livros.add(new Livro(2, "Livro 2", "Autor 2", "Editora 2", 200, 2020));
        livros.add(new Livro(3, "Livro 3", "Autor 3", "Editora 3", 300, 2021));
    }

    public Livro cadastrar(Livro livro){
        this.livros.add(livro);

        return livro;
    }

    public List<Livro> listarTodos(){
        return livros;
    }

    public Livro consultarPorId(int id){
        return livros.stream()
                .filter(l -> l.getId() == id)
                .findFirst().orElseThrow();
    }


    public Livro atualizar(Livro livro, int id){
        Livro livroFiltrado = livros.stream()
                .filter(l -> l.getId() == id)
                .findFirst().orElseThrow();

        livro.setId(livroFiltrado.getId());

        int indice = livros.indexOf(livroFiltrado);

        livros.set(indice, livro);

        return livro;
    }

    public void deletar(int id){
        Livro livroFiltrado = livros.stream()
                .filter(l -> l.getId() == id)
                .findFirst().orElseThrow();

        livros.remove(livroFiltrado);
    }
}
