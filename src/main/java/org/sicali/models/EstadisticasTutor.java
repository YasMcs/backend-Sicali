package org.sicali.models;

public class EstadisticasTutor {
    private int idTutor;
    private int idEstudiante;
    private String nombreEstudiante;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int idGrupo;
    private String nombreGrupo;
    private String grado;
    private int idPeriodo;
    private String nombrePeriodo;
    private String nombreAsignatura;
    private int calificacion;
    private double porcentajeAsistencia;

    public EstadisticasTutor(int idTutor, int idEstudiante, String nombreEstudiante,
                             String apellidoPaterno, String apellidoMaterno,
                             int idGrupo, String nombreGrupo, String grado,
                             int idPeriodo, String nombrePeriodo,
                             String nombreAsignatura, int calificacion,
                             double porcentajeAsistencia) {
        this.idTutor = idTutor;
        this.idEstudiante = idEstudiante;
        this.nombreEstudiante = nombreEstudiante;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.idGrupo = idGrupo;
        this.nombreGrupo = nombreGrupo;
        this.grado = grado;
        this.idPeriodo = idPeriodo;
        this.nombrePeriodo = nombrePeriodo;
        this.nombreAsignatura = nombreAsignatura;
        this.calificacion = calificacion;
        this.porcentajeAsistencia = porcentajeAsistencia;
    }

    // Getters
    public int getIdTutor() {
        return idTutor;
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

    public String getNombreCompletoEstudiante() {
        return nombreEstudiante + " " + apellidoPaterno + " " + apellidoMaterno;
    }

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

    public int getCalificacion() {
        return calificacion;
    }

    public double getPorcentajeAsistencia() {
        return porcentajeAsistencia;
    }

    // Setters
    public void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
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

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public void setPorcentajeAsistencia(double porcentajeAsistencia) {
        this.porcentajeAsistencia = porcentajeAsistencia;
    }
}