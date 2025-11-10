package org.sicali.models;

public class EstadisticasPorEstudiante {
    private int idEstudiante;
    private String nombreEstudiante;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int idPeriodo;
    private String nombrePeriodo;
    private String nombreAsignatura;
    private int calificacion;
    private double porcentajeAsistencia;

    public EstadisticasPorEstudiante(int idEstudiante, String nombreEstudiante,
                                     String apellidoPaterno, String apellidoMaterno,
                                     int idPeriodo, String nombrePeriodo,
                                     String nombreAsignatura, int calificacion,
                                     double porcentajeAsistencia) {
        this.idEstudiante = idEstudiante;
        this.nombreEstudiante = nombreEstudiante;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.idPeriodo = idPeriodo;
        this.nombrePeriodo = nombrePeriodo;
        this.nombreAsignatura = nombreAsignatura;
        this.calificacion = calificacion;
        this.porcentajeAsistencia = porcentajeAsistencia;
    }


    public int getIdEstudiante() {
        return idEstudiante;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getNombreCompleto() {
        return nombreEstudiante + " " + apellidoPaterno + " " + apellidoMaterno;
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

    public int getCalificacion() {
        return calificacion;
    }

    public double getPorcentajeAsistencia() {
        return porcentajeAsistencia;
    }


    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
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

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public void setPorcentajeAsistencia(double porcentajeAsistencia) {
        this.porcentajeAsistencia = porcentajeAsistencia;
    }
}