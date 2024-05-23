package com.senai.saep.repository;

import com.senai.saep.entity.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository extends JpaRepository<Estudante, Long>{
    
}
