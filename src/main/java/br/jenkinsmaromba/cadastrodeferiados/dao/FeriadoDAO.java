package br.jenkinsmaromba.cadastrodeferiados.dao;

import org.springframework.data.repository.CrudRepository;

import br.jenkinsmaromba.cadastrodeferiados.model.Feriado;

public interface FeriadoDAO extends CrudRepository<Feriado, Integer>{
    
}
