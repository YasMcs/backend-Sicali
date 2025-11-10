package org.sicali.routes;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.sicali.models.Periodo;
import org.sicali.services.PeriodoService;
import org.sicali.config.DatabaseConfig;

import java.sql.Connection;
import java.util.List;

public class PeriodoRoutes {

    public static void register(Javalin app) {
        app.get("/api/periodos", PeriodoRoutes::obtenerTodos);
        app.get("/api/periodos/{id}", PeriodoRoutes::obtenerPorId);
        app.post("/api/periodos", PeriodoRoutes::crear);
        app.put("/api/periodos/{id}", PeriodoRoutes::actualizar);
        app.delete("/api/periodos/{id}", PeriodoRoutes::eliminar);
        app.get("/api/periodos/ciclo/{idCiclo}", PeriodoRoutes::obtenerPorCiclo);
    }

    private static void obtenerTodos(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            PeriodoService service = new PeriodoService(conn);
            List<Periodo> periodos = service.obtenerTodosPeriodos();
            ctx.json(periodos);
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }

    private static void obtenerPorId(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            PeriodoService service = new PeriodoService(conn);
            Periodo periodo = service.obtenerPeriodoPorId(id);
            ctx.json(periodo);
        } catch (Exception e) {
            ctx.status(404).json("Error: " + e.getMessage());
        }
    }

    private static void crear(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            Periodo periodo = ctx.bodyAsClass(Periodo.class);
            PeriodoService service = new PeriodoService(conn);
            Periodo nuevoPeriodo = service.crearPeriodo(periodo);
            ctx.status(201).json(nuevoPeriodo);
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    private static void actualizar(Context ctx) {
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

    private static void eliminar(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            PeriodoService service = new PeriodoService(conn);
            service.eliminarPeriodo(id);
            ctx.json("Periodo eliminado");
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    private static void obtenerPorCiclo(Context ctx) {
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