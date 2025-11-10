package org.sicali.models;

import java.util.Date;

public class Ciclo {
    private int idCiclo;
    private Date fechaInicio;
    private Date fechaFin;

    public Ciclo(int idCiclo, Date fechaInicio, Date fechaFin) {
        this.idCiclo = idCiclo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(int idCiclo) {
        this.idCiclo = idCiclo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}