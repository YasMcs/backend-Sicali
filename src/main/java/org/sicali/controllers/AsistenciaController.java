package org.sicali.controllers;

import org.sicali.models.Asistencia;
import org.sicali.services.AsistenciaService;
import io.javalin.http.Context;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class AsistenciaController {
    private AsistenciaService asistenciaService;

    public AsistenciaController(Connection connection) {
        this.asistenciaService = new AsistenciaService(connection);
    }

    public Asistencia crearAsistencia(Asistencia asistencia) {
        try {
            return asistenciaService.crearAsistencia(asistencia);
        } catch (SQLException e) {
            System.err.println("Error al crear asistencia: " + e.getMessage());
            return null;
        }
    }

    public Asistencia obtenerAsistenciaPorId(int id) {
        try {
            return asistenciaService.obtenerAsistenciaPorId(id);
        } catch (SQLException e) {
            System.err.println("Error al obtener asistencia: " + e.getMessage());
            return null;
        }
    }

    public List<Asistencia> obtenerTodasAsistencias() {
        try {
            return asistenciaService.obtenerTodasAsistencias();
        } catch (SQLException e) {
            System.err.println("Error al obtener asistencias: " + e.getMessage());
            return null;
        }
    }

    public boolean actualizarAsistencia(Asistencia asistencia) {
        try {
            asistenciaService.actualizarAsistencia(asistencia);
            return true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar asistencia: " + e.getMessage());
            return false;
        }
    }


    public List<Asistencia> obtenerAsistenciasPorEstudiante(int idEstudiante) {
        try {
            return asistenciaService.obtenerAsistenciasPorEstudiante(idEstudiante);
        } catch (SQLException e) {
            System.err.println("Error al obtener asistencias por estudiante: " + e.getMessage());
            return null;
        }
    }

    public List<Asistencia> obtenerAsistenciasPorGrupo(int idGrupo) {
        try {
            return asistenciaService.obtenerAsistenciasPorGrupo(idGrupo);
        } catch (SQLException e) {
            System.err.println("Error al obtener asistencias por grupo: " + e.getMessage());
            return null;
        }
    }

    public List<Asistencia> obtenerAsistenciasPorFecha(Date fecha) {
        try {
            return asistenciaService.obtenerAsistenciasPorFecha(fecha);
        } catch (SQLException e) {
            System.err.println("Error al obtener asistencias por fecha: " + e.getMessage());
            return null;
        }
    }

    public Double calcularPorcentajeAsistencia(int idEstudiante, int idGrupo) {
        try {
            return asistenciaService.calcularPorcentajeAsistencia(idEstudiante, idGrupo);
        } catch (SQLException e) {
            System.err.println("Error al calcular porcentaje de asistencia: " + e.getMessage());
            return null;
        }
    }
}