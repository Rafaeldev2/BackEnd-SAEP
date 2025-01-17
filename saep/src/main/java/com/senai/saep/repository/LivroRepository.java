package com.senai.saep.repository;

import com.senai.saep.entity.Livro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository <Livro, Long>{
        List<Livro> findByTitulo(String titulo);
}
