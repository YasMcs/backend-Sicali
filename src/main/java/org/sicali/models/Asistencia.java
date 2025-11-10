package org.sicali.models;

import java.util.Date;

public class Asistencia {
    private int idAsistencia;
    private Usuario idEstudiante;
    private Date fecha;
    private Grupo idGrupo;
    private boolean asistencia;

    public Asistencia(int idAsistencia, Usuario idEstudiante, Date fecha, Grupo idGrupo, boolean asistencia) {
        this.idAsistencia = idAsistencia;
        this.idEstudiante = idEstudiante;
        this.fecha = fecha;
        this.idGrupo = idGrupo;
        this.asistencia = asistencia;
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public Usuario getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Usuario idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Grupo getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Grupo idGrupo) {
        this.idGrupo = idGrupo;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }
}