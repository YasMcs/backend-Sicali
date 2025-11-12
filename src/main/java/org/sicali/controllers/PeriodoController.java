package org.sicali.controllers;

import org.sicali.config.DatabaseConfig;
import org.sicali.models.Periodo;
import org.sicali.services.PeriodoService;
import io.javalin.http.Context;
import java.sql.Connection;
import java.util.List;

public class PeriodoController {

    public static void obtenerTodos(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            PeriodoService service = new PeriodoService(conn);
            List<Periodo> periodos = service.obtenerTodosPeriodos();
            ctx.json(periodos);
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }

    public static void obtenerPorId(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            PeriodoService service = new PeriodoService(conn);
            Periodo periodo = service.obtenerPeriodoPorId(id);
            ctx.json(periodo);
        } catch (Exception e) {
            ctx.status(404).json("Error: " + e.getMessage());
        }
    }

    public static void crear(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            Periodo periodo = ctx.bodyAsClass(Periodo.class);
            PeriodoService service = new PeriodoService(conn);
            Periodo nuevoPeriodo = service.crearPeriodo(periodo);
            ctx.status(201).json(nuevoPeriodo);
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    public static void actualizar(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            Periodo periodo = ctx.bodyAsClass(Periodo.class);
            periodo.setIdPeriodo(id);
            PeriodoService service = new PeriodoService(conn);
            service.actualizarPeriodo(periodo);
            ctx.json("Periodo actualizado");
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    public static void eliminar(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            PeriodoService service = new PeriodoService(conn);
            service.eliminarPeriodo(id);
            ctx.json("Periodo eliminado");
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    public static void obtenerPorCiclo(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int idCiclo = Integer.parseInt(ctx.pathParam("idCiclo"));
            PeriodoService service = new PeriodoService(conn);
            List<Periodo> periodos = service.obtenerPeriodosPorCiclo(idCiclo);
            ctx.json(periodos);
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }
}