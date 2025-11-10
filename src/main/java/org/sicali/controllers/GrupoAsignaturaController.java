package org.sicali.controllers;

import org.sicali.models.GrupoAsignatura;
import org.sicali.services.GrupoAsignaturaService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GrupoAsignaturaController {
    private GrupoAsignaturaService grupoAsignaturaService;

    public GrupoAsignaturaController(Connection connection) {
        this.grupoAsignaturaService = new GrupoAsignaturaService(connection);
    }

    public GrupoAsignatura crearGrupoAsignatura(GrupoAsignatura grupoAsignatura) {
        try {
            return grupoAsignaturaService.crearGrupoAsignatura(grupoAsignatura);
        } catch (SQLException e) {
            System.err.println("Error al crear grupo-asignatura: " + e.getMessage());
            return null;
        }
    }

    public GrupoAsignatura obtenerGrupoAsignaturaPorId(int id) {
        try {
            return grupoAsignaturaService.obtenerGrupoAsignaturaPorId(id);
        } catch (SQLException e) {
            System.err.println("Error al obtener grupo-asignatura: " + e.getMessage());
            return null;
        }
    }

    public List<GrupoAsignatura> obtenerTodosGrupoAsignaturas() {
        try {
            return grupoAsignaturaService.obtenerTodosGrupoAsignaturas();
        } catch (SQLException e) {
            System.err.println("Error al obtener grupos-asignaturas: " + e.getMessage());
            return null;
        }
    }

    public boolean actualizarGrupoAsignatura(GrupoAsignatura grupoAsignatura) {
        try {
            grupoAsignaturaService.actualizarGrupoAsignatura(grupoAsignatura);
            return true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar grupo-asignatura: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarGrupoAsignatura(int id) {
        try {
            grupoAsignaturaService.eliminarGrupoAsignatura(id);
            return true;
        } catch (SQLException e) {
            System.err.println("Error al eliminar grupo-asignatura: " + e.getMessage());
            return false;
        }
    }

    public List<GrupoAsignatura> obtenerAsignaturasPorGrupo(int idGrupo) {
        try {
            return grupoAsignaturaService.obtenerAsignaturasPorGrupo(idGrupo);
        } catch (SQLException e) {
            System.err.println("Error al obtener asignaturas por grupo: " + e.getMessage());
            return null;
        }
    }

    public List<GrupoAsignatura> obtenerGruposPorAsignatura(int idAsignatura) {
        try {
            return grupoAsignaturaService.obtenerGruposPorAsignatura(idAsignatura);
        } catch (SQLException e) {
            System.err.println("Error al obtener grupos por asignatura: " + e.getMessage());
            return null;
        }
    }
}