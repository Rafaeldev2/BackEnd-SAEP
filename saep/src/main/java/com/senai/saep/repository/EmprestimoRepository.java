package com.senai.saep.repository;

import com.senai.saep.entity.Emprestimo;
import com.senai.saep.entity.Estudante;
import com.senai.saep.entity.Livro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{
        List<Emprestimo> findByEstudante(Estudante estudante);
        
        Emprestimo findByLivro(Livro livro);
}
