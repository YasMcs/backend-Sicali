package org.sicali.models;

public class EstudianteGrupo {
    private GrupoAsignatura idGrupoAsignatura;
    private Usuario idEstudiante;
    private int calificacion;

    public EstudianteGrupo(GrupoAsignatura idGrupoAsignatura, Usuario idEstudiante, int calificacion) {
        this.idGrupoAsignatura = idGrupoAsignatura;
        this.idEstudiante = idEstudiante;
        this.calificacion = calificacion;
    }

    public GrupoAsignatura getIdGrupoAsignatura() {
        return idGrupoAsignatura;
    }

    public void setIdGrupoAsignatura(GrupoAsignatura idGrupoAsignatura) {
        this.idGrupoAsignatura = idGrupoAsignatura;
    }

    public Usuario getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Usuario idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}