package org.sicali.controllers;

import org.sicali.models.Ciclo;
import org.sicali.services.CicloService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CicloController {
    private CicloService cicloService;

    public CicloController(Connection connection) {
        this.cicloService = new CicloService(connection);
    }

    public Ciclo crearCiclo(Ciclo ciclo) {
        try {
            return cicloService.crearCiclo(ciclo);
        } catch (SQLException e) {
            System.err.println("Error al crear ciclo: " + e.getMessage());
            return null;
        }
    }

    public Ciclo obtenerCicloPorId(int id) {
        try {
            return cicloService.obtenerCicloPorId(id);
        } catch (SQLException e) {
            System.err.println("Error al obtener ciclo: " + e.getMessage());
            return null;
        }
    }

    public List<Ciclo> obtenerTodosCiclos() {
        try {
            return cicloService.obtenerTodosCiclos();
        } catch (SQLException e) {
            System.err.println("Error al obtener ciclos: " + e.getMessage());
            return null;
        }
    }

    public boolean actualizarCiclo(Ciclo ciclo) {
        try {
            cicloService.actualizarCiclo(ciclo);
            return true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar ciclo: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarCiclo(int id) {
        try {
            cicloService.eliminarCiclo(id);
            return true;
        } catch (SQLException e) {
            System.err.println("Error al eliminar ciclo: " + e.getMessage());
            return false;
        }
    }

    public Ciclo obtenerCicloActivo() {
        try {
            return cicloService.obtenerCicloActivo();
        } catch (SQLException e) {
            System.err.println("Error al obtener ciclo activo: " + e.getMessage());
            return null;
        }
    }
}