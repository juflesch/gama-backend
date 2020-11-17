package br.jenkinsmaromba.cadastrodeferiados.dao;

import org.springframework.data.repository.CrudRepository;

import br.jenkinsmaromba.cadastrodeferiados.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
    public Usuario findByFuncionalOrRacf(int funcional, String racf);
    
}
