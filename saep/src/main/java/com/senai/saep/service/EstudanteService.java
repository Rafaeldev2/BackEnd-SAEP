package com.senai.saep.service;

import com.senai.saep.entity.Estudante;
import com.senai.saep.repository.EstudanteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EstudanteService {
    
    @Autowired
    EstudanteRepository estudanteRepository;
    
    public Long incluirEstudante(Estudante estudante){
         return  estudanteRepository.save(estudante).getIdEstudante();
}
    
public Estudante consultaEstudante(Long idEstudante){
    Optional<Estudante> estude = estudanteRepository.findById(idEstudante);
        if(estude.isPresent()){
            return estude.get();
        } else {
            return null;
        }
}

public List<Estudante> listarEstudantes(){
        return estudanteRepository.findAll();
}

public Boolean atualizarEstuadante(Estudante estudante){
        Estudante estudanteBD = estudanteRepository.getReferenceById(estudante.getIdEstudante());
        if(estudanteBD != null){
            estudanteBD.setData_nascimento(estudante.getData_nascimento());
            estudanteBD.setEmail(estudante.getEmail());
            estudanteBD.setNome(estudante.getNome());
            estudanteBD.setTelefone(estudante.getTelefone());
            estudanteRepository.save(estudanteBD);
            return true;
        } else {
            return false;
        }  
}

public Boolean excluirEstudante(Long IdEstudante){
            Estudante estudante = estudanteRepository.getReferenceById(IdEstudante);
            if(estudante != null){
            estudanteRepository.deleteById(IdEstudante);
            return true;
            } else {
            return false;
            }
    }
}
