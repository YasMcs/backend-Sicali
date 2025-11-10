package org.sicali.models;

public class EstadisticasDocente {
    private int idGrupo;
    private String nombreGrupo;
    private String grado;
    private int idDocente;
    private int idPeriodo;
    private String nombrePeriodo;
    private int totalEstudiantes;
    private String nombreAsignatura;
    private double promedioCalificacion;
    private double porcentajeAsistencia;

    public EstadisticasDocente(int idGrupo, String nombreGrupo, String grado,
                               int idDocente, int idPeriodo, String nombrePeriodo,
                               int totalEstudiantes, String nombreAsignatura,
                               double promedioCalificacion, double porcentajeAsistencia) {
        this.idGrupo = idGrupo;
        this.nombreGrupo = nombreGrupo;
        this.grado = grado;
        this.idDocente = idDocente;
        this.idPeriodo = idPeriodo;
        this.nombrePeriodo = nombrePeriodo;
        this.totalEstudiantes = totalEstudiantes;
        this.nombreAsignatura = nombreAsignatura;
        this.promedioCalificacion = promedioCalificacion;
        this.porcentajeAsistencia = porcentajeAsistencia;
    }

    // Getters
    public int getIdGrupo() {
        return idGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public String getGrado() {
        return grado;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public String getNombrePeriodo() {
        return nombrePeriodo;
    }

    public int getTotalEstudiantes() {
        return totalEstudiantes;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public double getPromedioCalificacion() {
        return promedioCalificacion;
    }

    public double getPorcentajeAsistencia() {
        return porcentajeAsistencia;
    }

    // Setters
    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public void setNombrePeriodo(String nombrePeriodo) {
        this.nombrePeriodo = nombrePeriodo;
    }

    public void setTotalEstudiantes(int totalEstudiantes) {
        this.totalEstudiantes = totalEstudiantes;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public void setPromedioCalificacion(double promedioCalificacion) {
        this.promedioCalificacion = promedioCalificacion;
    }

    public void setPorcentajeAsistencia(double porcentajeAsistencia) {
        this.porcentajeAsistencia = porcentajeAsistencia;
    }
}