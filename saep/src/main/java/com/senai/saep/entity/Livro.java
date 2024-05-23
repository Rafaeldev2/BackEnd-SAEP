package com.senai.saep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="livros")
public class Livro {
    
    @Id
    @JoinColumn(nullable=false)
    private Long codLivro;
    
    @Column(nullable=false)
    private String titulo;
    
    @Column(nullable=false)
    private String autor;
    
    @Column(nullable=false)
    private Integer ano;

    public void setCodLivro(Long codLivro) {
        this.codLivro = codLivro;
    }    
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Long getCodLivro() {
        return codLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getAno() {
        return ano;
    }
    
    
    
}
