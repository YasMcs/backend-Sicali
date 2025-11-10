package org.sicali.models;

public class EstadisticasPorGrupo {
    private int idGrupo;
    private String nombreGrupo;
    private String grado;
    private int idPeriodo;
    private String nombrePeriodo;
    private String nombreAsignatura;
    private double promedioCalificaciones;
    private int totalEstudiantes;
    private double porcentajeAsistencia;

    public EstadisticasPorGrupo(int idGrupo, String nombreGrupo, String grado, int idPeriodo,
                                String nombrePeriodo, String nombreAsignatura,
                                double promedioCalificaciones, int totalEstudiantes,
                                double porcentajeAsistencia) {
        this.idGrupo = idGrupo;
        this.nombreGrupo = nombreGrupo;
        this.grado = grado;
        this.idPeriodo = idPeriodo;
        this.nombrePeriodo = nombrePeriodo;
        this.nombreAsignatura = nombreAsignatura;
        this.promedioCalificaciones = promedioCalificaciones;
        this.totalEstudiantes = totalEstudiantes;
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

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public String getNombrePeriodo() {
        return nombrePeriodo;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public double getPromedioCalificaciones() {
        return promedioCalificaciones;
    }

    public int getTotalEstudiantes() {
        return totalEstudiantes;
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

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public void setNombrePeriodo(String nombrePeriodo) {
        this.nombrePeriodo = nombrePeriodo;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public void setPromedioCalificaciones(double promedioCalificaciones) {
        this.promedioCalificaciones = promedioCalificaciones;
    }

    public void setTotalEstudiantes(int totalEstudiantes) {
        this.totalEstudiantes = totalEstudiantes;
    }

    public void setPorcentajeAsistencia(double porcentajeAsistencia) {
        this.porcentajeAsistencia = porcentajeAsistencia;
    }
}