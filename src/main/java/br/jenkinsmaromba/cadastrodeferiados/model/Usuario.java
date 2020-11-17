package br.jenkinsmaromba.cadastrodeferiados.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "funcional")
    private int funcional;

    @Column(name = "racf", length = 8, nullable = false, unique = true)
    private String racf;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "senha", length = 8, nullable = false)
    private String senha;

    @Column(name = "link_foto", length = 200)
    private String linkFoto;

    public int getFuncional() {
        return funcional;
    }

    public void setFuncional(int funcional) {
        this.funcional = funcional;
    }

    public String getRacf() {
        return racf;
    }

    public void setRacf(String racf) {
        this.racf = racf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }
    
}
