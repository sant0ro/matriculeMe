package com.unb.matriculeme.dao;

import javax.persistence.*;

@Entity
@Table(name = "turma")
public class SchoolClass {
    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    private int id;//Chave prim�ria da tabela Turmas

    @Column
    private String codigo;//SchoolClass de uma disciplina, pode valer de A-Z

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "professor_turma")
    private Professor professor;//'FK' Refer�ncia ao professor que ministrar� a disciplina

    @Column
    private int campos;//qual unidade regional da universidade a disciplina � ofertada

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "turma_oferta")
    private Offer offer;//lista de disciplinas e turmas disponiveis a matricula em um periodo letivo

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "tipo_reserva_id")
    private ReserveType reserveType;//Qualifica a reserva de uma turma como por exemplo se
    //ela � disponivel apenas a um determinado curso

    @Column
    private int vagas;//qtd de vagas em uma turma

    @Column(name = "vagas_reserva")
    private int vagasReserva;//qtd de vagas reservadas a um determinado curso

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public void setTiporeserva(ReserveType reserveType) {
        this.reserveType = reserveType;
    }

    public ReserveType getReserveType() {
        return reserveType;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public int getVagasReserva() {
        return vagasReserva;
    }

    public void setVagasReserva(int vagasReserva) {
        this.vagasReserva = vagasReserva;
    }

    public int getCampos() {
        return campos;
    }

    public void setCampos(int campos) {
        this.campos = campos;
    }
}