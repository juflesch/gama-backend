package br.jenkinsmaromba.cadastrodeferiados.dao;


import org.springframework.data.repository.CrudRepository;

import br.jenkinsmaromba.cadastrodeferiados.model.Agencia;

public interface AgenciaDAO extends CrudRepository<Agencia, Integer>{
    public Agencia findByNumAgencia(int numAgencia);
}
