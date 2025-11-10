package org.sicali.models;

public class Grupo {
    private int idGrupo;
    private String grupo;
    private String grado;       // ← nuevo atributo agregado
    private Periodo idPeriodo;
    private Usuario idDocente;

    // Constructor actualizado con el nuevo campo 'grado'
    public Grupo(int idGrupo, String grupo, String grado, Periodo idPeriodo, Usuario idDocente) {
        this.idGrupo = idGrupo;
        this.grupo = grupo;
        this.grado = grado;
        this.idPeriodo = idPeriodo;
        this.idDocente = idDocente;
    }

    // Getters y setters
    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getGrado() {       // ← nuevo getter
        return grado;
    }

    public void setGrado(String grado) {   // ← nuevo setter
        this.grado = grado;
    }

    public Periodo getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Periodo idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Usuario getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Usuario idDocente) {
        this.idDocente = idDocente;
    }
}
