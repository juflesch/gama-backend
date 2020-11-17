package br.jenkinsmaromba.cadastrodeferiados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.jenkinsmaromba.cadastrodeferiados.dao.UsuarioDAO;
import br.jenkinsmaromba.cadastrodeferiados.model.Usuario;

@RestController
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioDAO dao;

    // Login do usuário via Funcional ou RACF
    @PostMapping("/usuario/login")
    public ResponseEntity<Usuario> fazerLogin(@RequestBody Usuario user) {
        Usuario userEncontrado = dao.findByFuncionalOrRacf(user.getFuncional(), user.getRacf());
        
        if(userEncontrado != null){
            if(userEncontrado.getSenha().equals( user.getSenha() )){
                userEncontrado.setSenha("********");
                return ResponseEntity.ok(userEncontrado);
            }
        }
        return ResponseEntity.status(403).build();
    }


    
}
