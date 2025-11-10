package org.sicali.controllers;

import org.sicali.models.Periodo;
import org.sicali.services.PeriodoService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PeriodoController {
    private PeriodoService periodoService;

    public PeriodoController(Connection connection) {
        this.periodoService = new PeriodoService(connection);
    }

    public Periodo crearPeriodo(Periodo periodo) {
        try {
            return periodoService.crearPeriodo(periodo);
        } catch (SQLException e) {
            System.err.println("Error al crear periodo: " + e.getMessage());
            return null;
        }
    }

    public Periodo obtenerPeriodoPorId(int id) {
        try {
            return periodoService.obtenerPeriodoPorId(id);
        } catch (SQLException e) {
            System.err.println("Error al obtener periodo: " + e.getMessage());
            return null;
        }
    }

    public List<Periodo> obtenerTodosPeriodos() {
        try {
            return periodoService.obtenerTodosPeriodos();
        } catch (SQLException e) {
            System.err.println("Error al obtener periodos: " + e.getMessage());
            return null;
        }
    }

    public boolean actualizarPeriodo(Periodo periodo) {
        try {
            periodoService.actualizarPeriodo(periodo);
            return true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar periodo: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarPeriodo(int id) {
        try {
            periodoService.eliminarPeriodo(id);
            return true;
        } catch (SQLException e) {
            System.err.println("Error al eliminar periodo: " + e.getMessage());
            return false;
        }
    }

    public List<Periodo> obtenerPeriodosPorCiclo(int idCiclo) {
        try {
            return periodoService.obtenerPeriodosPorCiclo(idCiclo);
        } catch (SQLException e) {
            System.err.println("Error al obtener periodos por ciclo: " + e.getMessage());
            return null;
        }
    }
}