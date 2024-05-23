package com.senai.saep.controller;

import com.senai.saep.entity.Livro;
import com.senai.saep.service.LivroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LivroController {
    
    
    @Autowired
    private LivroService livroService;
    
    @PostMapping("/livro")
    public ResponseEntity<Object> incluirLivro(@RequestBody Livro livro){
        Long codLivro = livroService.incluirLivro(livro);
        if(codLivro !=null){
            return new ResponseEntity<>(codLivro, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    @GetMapping("/livro/{codLivro}")
    public ResponseEntity<Object> consultarLivro(@RequestParam("codLivro") Long codLivro){
        Livro livro = livroService.consultarLivro(codLivro);
        if(livro !=null){
            return new ResponseEntity<>(livro, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/livro")
    public ResponseEntity<Object> listarLivro(){
        List<Livro> livro = livroService.listarLivros();
        if(!livro.isEmpty()){
            return new ResponseEntity<>(livro, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/Livro/{codLivro}")
    public ResponseEntity<Object> excluirLivro(@RequestParam("codLivro") Long codLivro){
            if(livroService.excluirLivro(codLivro)){
                return new ResponseEntity<>(HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }
    
    @PutMapping("/livro")
    public ResponseEntity<Object> atualizarLivro(@RequestBody Livro livro){
        if(livroService.atualizarLivro(livro)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
