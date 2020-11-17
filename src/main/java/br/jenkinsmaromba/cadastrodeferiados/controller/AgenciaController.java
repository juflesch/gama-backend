package br.jenkinsmaromba.cadastrodeferiados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.jenkinsmaromba.cadastrodeferiados.dao.AgenciaDAO;
import br.jenkinsmaromba.cadastrodeferiados.model.Agencia;
import br.jenkinsmaromba.cadastrodeferiados.model.Feriado;

@RestController
@CrossOrigin("*")
public class AgenciaController {
    @Autowired
    private AgenciaDAO dao;

    // Retorna todas as agências cadastradas
    @GetMapping("/agencias")
    public ResponseEntity<List<Agencia>> listarAgencias() {
        List<Agencia> agencias = (List<Agencia>) dao.findAll();
        if (agencias != null) {
            return ResponseEntity.ok(agencias);
        }
        return ResponseEntity.status(404).build();
    }

    // Recuperar feriados por agencia
    @GetMapping("/agencia/feriados/{idAgencia}")
    public ResponseEntity<List<Feriado>> agenciaPorId(@PathVariable int idAgencia) {

        Agencia agencia = dao.findById(idAgencia).orElse(null);

        if (agencia != null) {
            List<Feriado> feriados = agencia.getFeriados();
            if (agencia.getNumAgencia() != 0) {
                Agencia agenciaTodos = dao.findByNumAgencia(0);
                List<Feriado> feriadoTodos = agenciaTodos.getFeriados();
                feriados.addAll(feriadoTodos);
            }
            return ResponseEntity.ok(feriados); 
        }
        return ResponseEntity.notFound().build();
    }

}
