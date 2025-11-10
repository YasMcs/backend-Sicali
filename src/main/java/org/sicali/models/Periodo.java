package org.sicali.models;

public class Periodo {
    private int idPeriodo;
    private Ciclo idCiclo;

    public Periodo(int idPeriodo, Ciclo idCiclo) {
        this.idPeriodo = idPeriodo;
        this.idCiclo = idCiclo;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Ciclo getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Ciclo idCiclo) {
        this.idCiclo = idCiclo;
    }
}