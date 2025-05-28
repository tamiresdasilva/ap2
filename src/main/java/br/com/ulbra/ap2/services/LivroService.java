package br.com.ulbra.ap2.services;

import br.com.ulbra.ap2.model.Livro;
import br.com.ulbra.ap2.repositories.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro cadastrar(Livro livro){
        return this.livroRepository.cadastrar(livro);
    }

    public List<Livro> listarTodos(){
        return this.livroRepository.listarTodos();
    }

    public Livro consultarPorId( int id){
        return this.livroRepository.consultarPorId(id);
    }


    public Livro atualizar(Livro livro, int id){
        return this.livroRepository.atualizar(livro, id);
    }

    public void deletar(int id){
        this.livroRepository.deletar(id);
    }
}
