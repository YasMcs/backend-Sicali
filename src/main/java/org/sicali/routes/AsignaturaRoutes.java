package org.sicali.routes;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.sicali.models.Asignatura;
import org.sicali.services.AsignaturaService;
import org.sicali.config.DatabaseConfig;

import java.sql.Connection;
import java.util.List;

public class AsignaturaRoutes {

    public static void register(Javalin app) {
        app.get("/api/asignaturas", AsignaturaRoutes::obtenerTodas);
        app.get("/api/asignaturas/{id}", AsignaturaRoutes::obtenerPorId);
        app.post("/api/asignaturas", AsignaturaRoutes::crear);
        app.put("/api/asignaturas/{id}", AsignaturaRoutes::actualizar);
        app.delete("/api/asignaturas/{id}", AsignaturaRoutes::eliminar);
    }
/*
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
    */
}