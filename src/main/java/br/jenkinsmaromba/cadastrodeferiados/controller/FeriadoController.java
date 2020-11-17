package br.jenkinsmaromba.cadastrodeferiados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.jenkinsmaromba.cadastrodeferiados.dao.FeriadoDAO;
import br.jenkinsmaromba.cadastrodeferiados.model.Feriado;

@RestController
@CrossOrigin("*")
public class FeriadoController {
    @Autowired
    private FeriadoDAO dao;


    // Retorna todos os feriados cadastrados
    @GetMapping("/feriados")
    public ResponseEntity<List<Feriado>> listarFeriados() {
        List<Feriado> feriados = (List<Feriado>)dao.findAll();
        if(feriados != null){
            return ResponseEntity.ok(feriados);
        }
        return ResponseEntity.status(404).build();
    }

    // Cadastrar novo feriado
    @PostMapping("/feriado/novo")
    public ResponseEntity<Feriado> novoFeriado(@RequestBody Feriado feriado) {
        Feriado novoFeriado = dao.save(feriado);
        if(novoFeriado != null){
            return ResponseEntity.ok(novoFeriado);
        }
        return ResponseEntity.badRequest().build();
    }



}
