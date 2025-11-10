package org.sicali.controllers;

import org.sicali.models.TutorEstudiante;
import org.sicali.services.TutorEstudianteService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TutorEstudianteController {
    private TutorEstudianteService tutorEstudianteService;

    public TutorEstudianteController(Connection connection) {
        this.tutorEstudianteService = new TutorEstudianteService(connection);
    }

    public TutorEstudiante crearTutorEstudiante(TutorEstudiante tutorEstudiante) {
        try {
            return tutorEstudianteService.crearTutorEstudiante(tutorEstudiante);
        } catch (SQLException e) {
            System.err.println("Error al crear tutor-estudiante: " + e.getMessage());
            return null;
        }
    }

    public TutorEstudiante obtenerTutorEstudiantePorIds(int idTutor, int idEstudiante) {
        try {
            return tutorEstudianteService.obtenerTutorEstudiantePorIds(idTutor, idEstudiante);
        } catch (SQLException e) {
            System.err.println("Error al obtener tutor-estudiante: " + e.getMessage());
            return null;
        }
    }

    public List<TutorEstudiante> obtenerTodosTutorEstudiantes() {
        try {
            return tutorEstudianteService.obtenerTodosTutorEstudiantes();
        } catch (SQLException e) {
            System.err.println("Error al obtener tutores-estudiantes: " + e.getMessage());
            return null;
        }
    }

    public boolean eliminarTutorEstudiante(int idTutor, int idEstudiante) {
        try {
            tutorEstudianteService.eliminarTutorEstudiante(idTutor, idEstudiante);
            return true;
        } catch (SQLException e) {
            System.err.println("Error al eliminar tutor-estudiante: " + e.getMessage());
            return false;
        }
    }

    public List<TutorEstudiante> obtenerEstudiantesPorTutor(int idTutor) {
        try {
            return tutorEstudianteService.obtenerEstudiantesPorTutor(idTutor);
        } catch (SQLException e) {
            System.err.println("Error al obtener estudiantes por tutor: " + e.getMessage());
            return null;
        }
    }

    public List<TutorEstudiante> obtenerTutoresPorEstudiante(int idEstudiante) {
        try {
            return tutorEstudianteService.obtenerTutoresPorEstudiante(idEstudiante);
        } catch (SQLException e) {
            System.err.println("Error al obtener tutores por estudiante: " + e.getMessage());
            return null;
        }
    }
}