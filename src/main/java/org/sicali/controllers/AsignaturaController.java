package org.sicali.controllers;
import org.sicali.config.DatabaseConfig;

import org.sicali.models.Asignatura;
import org.sicali.services.AsignaturaService;
import io.javalin.http.Context;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AsignaturaController {
    private final AsignaturaService asignaturaService;

    public AsignaturaController(Connection connection) {
        this.asignaturaService = new AsignaturaService(connection);
    }
    private static void obtenerTodas(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            AsignaturaService service = new AsignaturaService(conn);
            List<Asignatura> asignaturas = service.obtenerTodasAsignaturas();
            ctx.json(asignaturas);
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }

    private static void obtenerPorId(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            AsignaturaService service = new AsignaturaService(conn);
            Asignatura asignatura = service.obtenerAsignaturaPorId(id);
            ctx.json(asignatura);
        } catch (Exception e) {
            ctx.status(404).json("Error: " + e.getMessage());
        }
    }

    private static void crear(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            Asignatura asignatura = ctx.bodyAsClass(Asignatura.class);
            AsignaturaService service = new AsignaturaService(conn);
            Asignatura nuevaAsignatura = service.crearAsignatura(asignatura);
            ctx.status(201).json(nuevaAsignatura);
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    private static void actualizar(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            Asignatura asignatura = ctx.bodyAsClass(Asignatura.class);
            asignatura.setIdAsignatura(id);

            AsignaturaService service = new AsignaturaService(conn);
            service.actualizarAsignatura(asignatura);
            ctx.json("Asignatura actualizada");
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    private static void eliminar(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            AsignaturaService service = new AsignaturaService(conn);
            service.eliminarAsignatura(id);
            ctx.json("Asignatura eliminada");
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }
}