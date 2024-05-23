package com.senai.saep.service;

import com.senai.saep.entity.Emprestimo;
import com.senai.saep.entity.Estudante;
import com.senai.saep.entity.Livro;
import com.senai.saep.repository.EmprestimoRepository;
import com.senai.saep.repository.EstudanteRepository;
import com.senai.saep.repository.LivroRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmprestimoService {
    
    @Autowired
    EmprestimoRepository emprestimoRepository;
    
    @Autowired
    EstudanteRepository estudanteRepository;
    
    @Autowired
    LivroRepository livroRepository;
    
    public Long incluirEmprestimo(Emprestimo emprestimo, Long IdEstudante, Long CodLivro){
        emprestimo.setEstudante(estudanteRepository.getReferenceById(IdEstudante));
        emprestimo.setLivro(livroRepository.getReferenceById(CodLivro));
        return emprestimoRepository.save(emprestimo).getCodeEmprestimo();
    }
    
    public Emprestimo consultarEmprestimo(Long codeEmprestimo){
        Optional<Emprestimo> emprestimo = emprestimoRepository.findById(codeEmprestimo);
        if(emprestimo.isPresent()){
            return emprestimo.get();
        } else {
            return null;
        }
    }
    
    public List<Emprestimo> listarEmprestimos(){
            return emprestimoRepository.findAll();
    }
    
    public Boolean excluirEmprestimo(Long codeEmprestimo){
            Optional <Emprestimo> emprestimo = emprestimoRepository.findById(codeEmprestimo);
            if(emprestimo.isPresent()){
            emprestimoRepository.deleteById(codeEmprestimo);
            return true;
            } else {
            return false;
            }
    }
    
    public Boolean atualizarEmprestimo(Emprestimo emprestimo, Long IdEstudante, Long CodLivro){
        Emprestimo emprestimoBD = emprestimoRepository.getReferenceById(emprestimo.getCodeEmprestimo());
        if(emprestimoBD != null){
            emprestimo.setEstudante(estudanteRepository.getReferenceById(IdEstudante));
            emprestimo.setLivro(livroRepository.getReferenceById(CodLivro));
            emprestimoBD.setDataEmprestimo(emprestimo.getDataEmprestimo());
            emprestimoBD.setDataEntega(emprestimo.getDataEntega());
            emprestimoRepository.save(emprestimoBD);
            return true;
        }
            return false;
    }
    
    public List<Emprestimo> consultaEmprestimoPorTitulo(String titulo){
                List<Livro> livros  = livroRepository.findByTitulo(titulo);
                List<Emprestimo> listaEmp = new ArrayList();
                for(Livro livro : livros){
                    listaEmp.add(emprestimoRepository.findByLivro(livro));
                }
                if( !listaEmp.isEmpty()){
                    return listaEmp;
                } else {
                    return null;
                }
    }
    
    public List<Emprestimo> consultaEmprestimoPorEstudante(Long IdEstudante){
                Optional <Estudante> estudante = estudanteRepository.findById(IdEstudante);
                        if(estudante.isPresent()){
                            return emprestimoRepository.findByEstudante(estudante.get());
                        }
                        return null;
    }    
}
