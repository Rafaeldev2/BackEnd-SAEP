package com.senai.saep.controller;

import com.senai.saep.entity.Emprestimo;
import com.senai.saep.service.EmprestimoService;
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
public class EmprestimoController {
        
    @Autowired
    private EmprestimoService emprestimoSrv;
    
    @GetMapping("/emprestimo")
    public ResponseEntity<Object> consultaEmprestimo(){
            List<Emprestimo>listaEmp = emprestimoSrv.listarEmprestimos();
            if( !listaEmp.isEmpty() ){
                return   new ResponseEntity<>(listaEmp, HttpStatus.OK);
            } else {
                return  new ResponseEntity<>(listaEmp, HttpStatus.NOT_FOUND);
            }
    }
    
    @GetMapping("/emprestimo/{codEmprestimo}")
    public ResponseEntity<Object> consultaEmprestimoPorID(@RequestParam("codEmprestimo") Long codEmprestimo){
            Emprestimo Emp = emprestimoSrv.consultarEmprestimo(codEmprestimo);
            if( Emp != null ){
                return   new ResponseEntity<>(Emp, HttpStatus.OK);
            } else {
                return  new ResponseEntity<>(Emp, HttpStatus.NOT_FOUND);
            }
    }
    
    @GetMapping("/emprestimo/titulo/{titulo}")
    public ResponseEntity<Object> consultaEmprestimoPorTitulo(@RequestParam("titulo") String titulo){
            List<Emprestimo>listaEmp = emprestimoSrv.consultaEmprestimoPorTitulo(titulo);
            if( !listaEmp.isEmpty() ){
                return   new ResponseEntity<>(listaEmp, HttpStatus.OK);
            } else {
                return  new ResponseEntity<>(listaEmp, HttpStatus.NOT_FOUND);
            }
    }
    
    @GetMapping("/emprestimo/estudante/{IdEstudante}")
    public ResponseEntity<Object> consultaEmprestimoPorEstudante(@RequestParam("IdEstudante") Long IdEstudante){
            List<Emprestimo>listaEmp = emprestimoSrv.consultaEmprestimoPorEstudante(IdEstudante);
            if( !listaEmp.isEmpty() ){
                return   new ResponseEntity<>(listaEmp, HttpStatus.OK);
            } else {
                return  new ResponseEntity<>(listaEmp, HttpStatus.NOT_FOUND);
            }
    }
    
    @PostMapping("/emprestimo/{IdEstudante}/{codLivro}")
    public ResponseEntity<Object> incluirEmprestimo(@RequestBody Emprestimo emprestimo,
                                                                                @RequestParam("IdEstudante") Long IdEstudante,
                                                                                @RequestParam("codLivro") Long codLivro){
    
        Long IdEmp = emprestimoSrv.incluirEmprestimo(emprestimo, IdEstudante, codLivro);
        if( IdEmp != null){
                return   new ResponseEntity<>(IdEmp, HttpStatus.OK);
            } else {
                return  new ResponseEntity<>(IdEmp, HttpStatus.NOT_FOUND);
            }
    }
    
    

    @PutMapping("/emprestimo/{IdEstudante}/{codLivro}")
    public ResponseEntity<Object> alterarEmprestimo(@RequestBody Emprestimo emprestimo,
                                                                                @RequestParam("IdEstudante") Long IdEstudante,
                                                                                @RequestParam("codLivro") Long codLivro){
    
        if(emprestimoSrv.atualizarEmprestimo(emprestimo, IdEstudante, codLivro)){
                return   new ResponseEntity<>(HttpStatus.OK);
            } else {
                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }
    
    @DeleteMapping("/emprestimo/{codEmprestimo}")
    public ResponseEntity<Object> deletaEmprestimo(@RequestParam("codEmprestimo") Long codEmprestimo){
            Emprestimo Emp = emprestimoSrv.consultarEmprestimo(codEmprestimo);
            if( Emp != null ){
                return   new ResponseEntity<>(Emp, HttpStatus.OK);
            } else {
                return  new ResponseEntity<>(Emp, HttpStatus.NOT_FOUND);
            }
    }
}
