package org.sicali.models;

public class GrupoAsignatura {
    private int idGrupoAsignatura;
    private Grupo idGrupo;
    private Asignatura idAsignatura;

    public GrupoAsignatura(int idGrupoAsignatura, Grupo idGrupo, Asignatura idAsignatura) {
        this.idGrupoAsignatura = idGrupoAsignatura;
        this.idGrupo = idGrupo;
        this.idAsignatura = idAsignatura;
    }

    public int getIdGrupoAsignatura() {
        return idGrupoAsignatura;
    }

    public void setIdGrupoAsignatura(int idGrupoAsignatura) {
        this.idGrupoAsignatura = idGrupoAsignatura;
    }

    public Grupo getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Grupo idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Asignatura getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Asignatura idAsignatura) {
        this.idAsignatura = idAsignatura;
    }
}