package com.senai.saep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="estudantes")
public class Estudante {
    
        @Id
        @Column(nullable=false)
        private Long IdEstudante;
        
        @Column(nullable=false)
        private String nome;
        
        @Column(nullable=true)
        private Date data_nascimento;
        
        @Column(nullable=true)
        private String email;
        
        @Column(nullable=false)
        private String telefone;
        
        @OneToMany
        private Set<Emprestimo> emprestimo;

    public void setIdEstudante(Long IdEstudante) {
        this.IdEstudante = IdEstudante;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmprestimo(Set<Emprestimo> emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Long getIdEstudante() {
        return IdEstudante;
    }

    public String getNome() {
        return nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public Set<Emprestimo> getEmprestimo() {
        return emprestimo;
    }
        
        
        
        
        
}
