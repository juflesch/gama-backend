package br.jenkinsmaromba.cadastrodeferiados.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "itmn330_feriado")
public class Feriado {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_feriado")
    private int idFeriado;

    @Column(name = "nome_feriado", length = 50, nullable = false)
    private String nomeFeriado;

    @Column(name = "data_inicio", nullable = false)
    //@JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;

    @Column(name = "data_fim", nullable = false)
    //@JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFim;

    
    @ManyToOne
    @JoinColumn(name = "id_agencia")
    @JsonIgnoreProperties("feriados")
    private Agencia agencia;

    public int getIdFeriado() {
        return idFeriado;
    }
    
    public void setIdFeriado(int idFeriado) {
        this.idFeriado = idFeriado;
    }

    public String getNomeFeriado() {
        return nomeFeriado;
    }

    public void setNomeFeriado(String nomeFeriado) {
        this.nomeFeriado = nomeFeriado;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    
}
