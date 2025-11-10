package org.sicali.controllers;

import org.sicali.models.Grupo;
import org.sicali.services.GrupoService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GrupoController {
    private GrupoService grupoService;

    public GrupoController(Connection connection) {
        this.grupoService = new GrupoService(connection);
    }

    public Grupo crearGrupo(Grupo grupo) {
        try {
            return grupoService.crearGrupo(grupo);
        } catch (SQLException e) {
            System.err.println("Error al crear grupo: " + e.getMessage());
            return null;
        }
    }

    public Grupo obtenerGrupoPorId(int id) {
        try {
            return grupoService.obtenerGrupoPorId(id);
        } catch (SQLException e) {
            System.err.println("Error al obtener grupo: " + e.getMessage());
            return null;
        }
    }

    public List<Grupo> obtenerTodosGrupos() {
        try {
            return grupoService.obtenerTodosGrupos();
        } catch (SQLException e) {
            System.err.println("Error al obtener grupos: " + e.getMessage());
            return null;
        }
    }

    public boolean actualizarGrupo(Grupo grupo) {
        try {
            grupoService.actualizarGrupo(grupo);
            return true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar grupo: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarGrupo(int id) {
        try {
            grupoService.eliminarGrupo(id);
            return true;
        } catch (SQLException e) {
            System.err.println("Error al eliminar grupo: " + e.getMessage());
            return false;
        }
    }

    public List<Grupo> obtenerGruposPorDocente(int idDocente) {
        try {
            return grupoService.obtenerGruposPorDocente(idDocente);
        } catch (SQLException e) {
            System.err.println("Error al obtener grupos por docente: " + e.getMessage());
            return null;
        }
    }

    public List<Grupo> obtenerGruposPorPeriodo(int idPeriodo) {
        try {
            return grupoService.obtenerGruposPorPeriodo(idPeriodo);
        } catch (SQLException e) {
            System.err.println("Error al obtener grupos por periodo: " + e.getMessage());
            return null;
        }
    }
}