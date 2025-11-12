package org.sicali.controllers;

import org.sicali.config.DatabaseConfig;
import org.sicali.models.Ciclo;
import org.sicali.services.CicloService;
import io.javalin.http.Context;
import java.sql.Connection;
import java.util.List;

public class CicloController {

    public static void obtenerTodos(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            CicloService service = new CicloService(conn);
            List<Ciclo> ciclos = service.obtenerTodosCiclos();
            ctx.json(ciclos);
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }

    public static void obtenerPorId(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            CicloService service = new CicloService(conn);
            Ciclo ciclo = service.obtenerCicloPorId(id);
            ctx.json(ciclo);
        } catch (Exception e) {
            ctx.status(404).json("Error: " + e.getMessage());
        }
    }

    public static void crear(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            Ciclo ciclo = ctx.bodyAsClass(Ciclo.class);
            CicloService service = new CicloService(conn);
            Ciclo nuevoCiclo = service.crearCiclo(ciclo);
            ctx.status(201).json(nuevoCiclo);
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    public static void actualizar(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            Ciclo ciclo = ctx.bodyAsClass(Ciclo.class);
            ciclo.setIdCiclo(id);
            CicloService service = new CicloService(conn);
            service.actualizarCiclo(ciclo);
            ctx.json("Ciclo actualizado");
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    public static void eliminar(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            CicloService service = new CicloService(conn);
            service.eliminarCiclo(id);
            ctx.json("Ciclo eliminado");
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    public static void obtenerActivo(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            CicloService service = new CicloService(conn);
            Ciclo cicloActivo = service.obtenerCicloActivo();
            if (cicloActivo != null) {
                ctx.json(cicloActivo);
            } else {
                ctx.status(404).json("No hay ciclo activo");
            }
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }
}