package org.sicali.controllers;

import org.sicali.config.DatabaseConfig;
import org.sicali.models.GrupoAsignatura;
import org.sicali.services.GrupoAsignaturaService;
import io.javalin.http.Context;
import java.sql.Connection;
import java.util.List;

public class GrupoAsignaturaController {

    public static void obtenerTodos(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            GrupoAsignaturaService service = new GrupoAsignaturaService(conn);
            List<GrupoAsignatura> grupoAsignaturas = service.obtenerTodosGrupoAsignaturas();
            ctx.json(grupoAsignaturas);
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }

    public static void obtenerPorId(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            GrupoAsignaturaService service = new GrupoAsignaturaService(conn);
            GrupoAsignatura grupoAsignatura = service.obtenerGrupoAsignaturaPorId(id);
            ctx.json(grupoAsignatura);
        } catch (Exception e) {
            ctx.status(404).json("Error: " + e.getMessage());
        }
    }

    public static void crear(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            GrupoAsignatura grupoAsignatura = ctx.bodyAsClass(GrupoAsignatura.class);
            GrupoAsignaturaService service = new GrupoAsignaturaService(conn);
            GrupoAsignatura nuevoGrupoAsignatura = service.crearGrupoAsignatura(grupoAsignatura);
            ctx.status(201).json(nuevoGrupoAsignatura);
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    public static void actualizar(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            GrupoAsignatura grupoAsignatura = ctx.bodyAsClass(GrupoAsignatura.class);
            grupoAsignatura.setIdGrupoAsignatura(id);
            GrupoAsignaturaService service = new GrupoAsignaturaService(conn);
            service.actualizarGrupoAsignatura(grupoAsignatura);
            ctx.json("Grupo-Asignatura actualizado");
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    public static void eliminar(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            GrupoAsignaturaService service = new GrupoAsignaturaService(conn);
            service.eliminarGrupoAsignatura(id);
            ctx.json("Grupo-Asignatura eliminado");
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    public static void obtenerAsignaturasPorGrupo(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int idGrupo = Integer.parseInt(ctx.pathParam("idGrupo"));
            GrupoAsignaturaService service = new GrupoAsignaturaService(conn);
            List<GrupoAsignatura> grupoAsignaturas = service.obtenerAsignaturasPorGrupo(idGrupo);
            ctx.json(grupoAsignaturas);
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }

    public static void obtenerGruposPorAsignatura(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int idAsignatura = Integer.parseInt(ctx.pathParam("idAsignatura"));
            GrupoAsignaturaService service = new GrupoAsignaturaService(conn);
            List<GrupoAsignatura> grupoAsignaturas = service.obtenerGruposPorAsignatura(idAsignatura);
            ctx.json(grupoAsignaturas);
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }
}