package org.sicali.routes;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.sicali.models.Grupo;
import org.sicali.services.GrupoService;
import org.sicali.config.DatabaseConfig;

import java.sql.Connection;
import java.util.List;

public class GrupoRoutes {

    public static void register(Javalin app) {
        app.get("/api/grupos", GrupoRoutes::obtenerTodos);
        app.get("/api/grupos/{id}", GrupoRoutes::obtenerPorId);
        app.post("/api/grupos", GrupoRoutes::crear);
        app.put("/api/grupos/{id}", GrupoRoutes::actualizar);
        app.delete("/api/grupos/{id}", GrupoRoutes::eliminar);
        app.get("/api/grupos/docente/{idDocente}", GrupoRoutes::obtenerPorDocente);
        app.get("/api/grupos/periodo/{idPeriodo}", GrupoRoutes::obtenerPorPeriodo);
    }

    private static void obtenerTodos(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            GrupoService service = new GrupoService(conn);
            List<Grupo> grupos = service.obtenerTodosGrupos();
            ctx.json(grupos);
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }

    private static void obtenerPorId(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            GrupoService service = new GrupoService(conn);
            Grupo grupo = service.obtenerGrupoPorId(id);
            ctx.json(grupo);
        } catch (Exception e) {
            ctx.status(404).json("Error: " + e.getMessage());
        }
    }

    private static void crear(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            Grupo grupo = ctx.bodyAsClass(Grupo.class);
            GrupoService service = new GrupoService(conn);
            Grupo nuevoGrupo = service.crearGrupo(grupo);
            ctx.status(201).json(nuevoGrupo);
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    private static void actualizar(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            Grupo grupo = ctx.bodyAsClass(Grupo.class);
            grupo.setIdGrupo(id);

            GrupoService service = new GrupoService(conn);
            service.actualizarGrupo(grupo);
            ctx.json("Grupo actualizado");
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    private static void eliminar(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            GrupoService service = new GrupoService(conn);
            service.eliminarGrupo(id);
            ctx.json("Grupo eliminado");
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    private static void obtenerPorDocente(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int idDocente = Integer.parseInt(ctx.pathParam("idDocente"));
            GrupoService service = new GrupoService(conn);
            List<Grupo> grupos = service.obtenerGruposPorDocente(idDocente);
            ctx.json(grupos);
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }

    private static void obtenerPorPeriodo(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int idPeriodo = Integer.parseInt(ctx.pathParam("idPeriodo"));
            GrupoService service = new GrupoService(conn);
            List<Grupo> grupos = service.obtenerGruposPorPeriodo(idPeriodo);
            ctx.json(grupos);
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }
}