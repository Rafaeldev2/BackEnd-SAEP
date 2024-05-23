package com.senai.saep.service;

import com.senai.saep.entity.Livro;
import com.senai.saep.repository.LivroRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
    
    @Autowired
    LivroRepository livroRepository;
    
    
    public Long incluirLivro(Livro livro){
        return livroRepository.save(livro).getCodLivro();
    }
    
    public Livro consultarLivro(Long codLivro){
        Optional<Livro> livro = livroRepository.findById(codLivro);
        if(livro.isPresent()){
            return livro.get();
        } else {
            return null;
        }
    }
    
    public List<Livro> listarLivros(){
            return livroRepository.findAll();
    }
    
    public Boolean atualizarLivro(Livro livro){
        Livro livroBD = livroRepository.getReferenceById(livro.getCodLivro());
        if(livroBD != null){
            livroBD.setAno(livro.getAno());
            livroBD.setAutor(livro.getAutor());
            livroBD.setTitulo(livro.getTitulo());
            livroRepository.save(livroBD);
            return true;
        } else {
            return false;
        }  
    }
    
    public Boolean excluirLivro(Long IdLivro){
            Livro livroBD = livroRepository.getReferenceById(IdLivro);
            if(livroBD != null){
            livroRepository.deleteById(IdLivro);
            return true;
            } else {
            return false;
            }
    }
}
