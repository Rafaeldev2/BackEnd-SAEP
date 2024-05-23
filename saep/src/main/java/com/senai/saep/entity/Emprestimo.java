package com.senai.saep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name="emprestimos")
public class Emprestimo {
    
        @Id
        @Column(nullable=false)
        private Long codeEmprestimo;
        
        @OneToOne
        @JoinColumn
        private Livro livro;
        
        @ManyToOne
        @JoinColumn
        private Estudante estudante;
        
        @Column(nullable=false)
        private Date dataEmprestimo;
        
        @Column(nullable=false)
        private Date dataEntega;

    public void setCodeEmprestimo(Long codeEmprestimo) {
        this.codeEmprestimo = codeEmprestimo;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setDataEntega(Date dataEntega) {
        this.dataEntega = dataEntega;
    }

    public Long getCodeEmprestimo() {
        return codeEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Date getDataEntega() {
        return dataEntega;
    }
}
