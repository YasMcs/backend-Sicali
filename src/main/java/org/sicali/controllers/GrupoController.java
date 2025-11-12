package org.sicali.controllers;

import org.sicali.config.DatabaseConfig;
import org.sicali.models.Grupo;
import org.sicali.services.GrupoService;
import io.javalin.http.Context;
import java.sql.Connection;
import java.util.List;

public class GrupoController {

    public static void obtenerTodos(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            GrupoService service = new GrupoService(conn);
            List<Grupo> grupos = service.obtenerTodosGrupos();
            ctx.json(grupos);
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }

    public static void obtenerPorId(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            GrupoService service = new GrupoService(conn);
            Grupo grupo = service.obtenerGrupoPorId(id);
            ctx.json(grupo);
        } catch (Exception e) {
            ctx.status(404).json("Error: " + e.getMessage());
        }
    }

    public static void crear(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            Grupo grupo = ctx.bodyAsClass(Grupo.class);
            GrupoService service = new GrupoService(conn);
            Grupo nuevoGrupo = service.crearGrupo(grupo);
            ctx.status(201).json(nuevoGrupo);
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    public static void actualizar(Context ctx) {
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

    public static void eliminar(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            GrupoService service = new GrupoService(conn);
            service.eliminarGrupo(id);
            ctx.json("Grupo eliminado");
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    public static void obtenerPorDocente(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int idDocente = Integer.parseInt(ctx.pathParam("idDocente"));
            GrupoService service = new GrupoService(conn);
            List<Grupo> grupos = service.obtenerGruposPorDocente(idDocente);
            ctx.json(grupos);
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }

    public static void obtenerPorPeriodo(Context ctx) {
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