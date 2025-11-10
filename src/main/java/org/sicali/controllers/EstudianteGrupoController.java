package org.sicali.controllers;

import org.sicali.models.EstudianteGrupo;
import org.sicali.services.EstudianteGrupoService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EstudianteGrupoController {
    private EstudianteGrupoService estudianteGrupoService;

    public EstudianteGrupoController(Connection connection) {
        this.estudianteGrupoService = new EstudianteGrupoService(connection);
    }

    public EstudianteGrupo crearEstudianteGrupo(EstudianteGrupo estudianteGrupo) {
        try {
            return estudianteGrupoService.crearEstudianteGrupo(estudianteGrupo);
        } catch (SQLException e) {
            System.err.println("Error al crear estudiante-grupo: " + e.getMessage());
            return null;
        }
    }

    public EstudianteGrupo obtenerEstudianteGrupoPorIds(int idGrupoAsignatura, int idEstudiante) {
        try {
            return estudianteGrupoService.obtenerEstudianteGrupoPorIds(idGrupoAsignatura, idEstudiante);
        } catch (SQLException e) {
            System.err.println("Error al obtener estudiante-grupo: " + e.getMessage());
            return null;
        }
    }

    public List<EstudianteGrupo> obtenerTodosEstudiantesGrupos() {
        try {
            return estudianteGrupoService.obtenerTodosEstudiantesGrupos();
        } catch (SQLException e) {
            System.err.println("Error al obtener estudiantes-grupos: " + e.getMessage());
            return null;
        }
    }

    public boolean actualizarCalificacion(int idGrupoAsignatura, int idEstudiante, int nuevaCalificacion) {
        try {
            estudianteGrupoService.actualizarCalificacion(idGrupoAsignatura, idEstudiante, nuevaCalificacion);
            return true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar calificación: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarEstudianteGrupo(int idGrupoAsignatura, int idEstudiante) {
        try {
            estudianteGrupoService.eliminarEstudianteGrupo(idGrupoAsignatura, idEstudiante);
            return true;
        } catch (SQLException e) {
            System.err.println("Error al eliminar estudiante-grupo: " + e.getMessage());
            return false;
        }
    }

    public List<EstudianteGrupo> obtenerEstudiantesPorGrupoAsignatura(int idGrupoAsignatura) {
        try {
            return estudianteGrupoService.obtenerEstudiantesPorGrupoAsignatura(idGrupoAsignatura);
        } catch (SQLException e) {
            System.err.println("Error al obtener estudiantes por grupo-asignatura: " + e.getMessage());
            return null;
        }
    }

    public List<EstudianteGrupo> obtenerGruposPorEstudiante(int idEstudiante) {
        try {
            return estudianteGrupoService.obtenerGruposPorEstudiante(idEstudiante);
        } catch (SQLException e) {
            System.err.println("Error al obtener grupos por estudiante: " + e.getMessage());
            return null;
        }
    }

    public Double calcularPromedioEstudiante(int idEstudiante) {
        try {
            return estudianteGrupoService.calcularPromedioEstudiante(idEstudiante);
        } catch (SQLException e) {
            System.err.println("Error al calcular promedio del estudiante: " + e.getMessage());
            return null;
        }
    }
}