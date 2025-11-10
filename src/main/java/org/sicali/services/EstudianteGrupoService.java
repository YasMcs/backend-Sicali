package org.sicali.services;

import org.sicali.models.EstudianteGrupo;
import org.sicali.repositories.EstudianteGrupoRepository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EstudianteGrupoService {
    private EstudianteGrupoRepository estudianteGrupoRepository;

    public EstudianteGrupoService(Connection connection) {
        this.estudianteGrupoRepository = new EstudianteGrupoRepository(connection);
    }

    public EstudianteGrupo crearEstudianteGrupo(EstudianteGrupo estudianteGrupo) throws SQLException {
        validarEstudianteGrupo(estudianteGrupo);
        return estudianteGrupoRepository.crear(estudianteGrupo);
    }

    public EstudianteGrupo obtenerEstudianteGrupoPorIds(int idGrupoAsignatura, int idEstudiante) throws SQLException {
        EstudianteGrupo estudianteGrupo = estudianteGrupoRepository.obtenerPorIds(idGrupoAsignatura, idEstudiante);
        if (estudianteGrupo == null) {
            throw new SQLException("Estudiante-Grupo no encontrado");
        }
        return estudianteGrupo;
    }

    public List<EstudianteGrupo> obtenerTodosEstudiantesGrupos() throws SQLException {
        return estudianteGrupoRepository.obtenerTodos();
    }

    public void actualizarCalificacion(int idGrupoAsignatura, int idEstudiante, int nuevaCalificacion) throws SQLException {
        validarCalificacion(nuevaCalificacion);
        EstudianteGrupo estudianteGrupo = estudianteGrupoRepository.obtenerPorIds(idGrupoAsignatura, idEstudiante);
        if (estudianteGrupo == null) {
            throw new SQLException("Estudiante-Grupo no encontrado");
        }
        estudianteGrupo.setCalificacion(nuevaCalificacion);
        estudianteGrupoRepository.actualizar(estudianteGrupo);
    }

    public void eliminarEstudianteGrupo(int idGrupoAsignatura, int idEstudiante) throws SQLException {
        estudianteGrupoRepository.eliminar(idGrupoAsignatura, idEstudiante);
    }

    public List<EstudianteGrupo> obtenerEstudiantesPorGrupoAsignatura(int idGrupoAsignatura) throws SQLException {
        List<EstudianteGrupo> estudiantesGrupos = estudianteGrupoRepository.obtenerTodos();
        estudiantesGrupos.removeIf(eg -> eg.getIdGrupoAsignatura().getIdGrupoAsignatura() != idGrupoAsignatura);
        return estudiantesGrupos;
    }

    public List<EstudianteGrupo> obtenerGruposPorEstudiante(int idEstudiante) throws SQLException {
        List<EstudianteGrupo> estudiantesGrupos = estudianteGrupoRepository.obtenerTodos();
        estudiantesGrupos.removeIf(eg -> eg.getIdEstudiante().getId_usuario() != idEstudiante);
        return estudiantesGrupos;
    }

    public double calcularPromedioEstudiante(int idEstudiante) throws SQLException {
        List<EstudianteGrupo> estudiantesGrupos = obtenerGruposPorEstudiante(idEstudiante);
        if (estudiantesGrupos.isEmpty()) {
            return 0.0;
        }
        double suma = estudiantesGrupos.stream().mapToInt(EstudianteGrupo::getCalificacion).sum();
        return suma / estudiantesGrupos.size();
    }

    private void validarEstudianteGrupo(EstudianteGrupo estudianteGrupo) throws SQLException {
        if (estudianteGrupo.getIdGrupoAsignatura() == null) {
            throw new SQLException("El grupo-asignatura es requerido");
        }
        if (estudianteGrupo.getIdEstudiante() == null) {
            throw new SQLException("El estudiante es requerido");
        }
        validarCalificacion(estudianteGrupo.getCalificacion());
    }

    private void validarCalificacion(int calificacion) throws SQLException {
        if (calificacion < 0 || calificacion > 100) {
            throw new SQLException("La calificación debe estar entre 0 y 100");
        }
    }
}