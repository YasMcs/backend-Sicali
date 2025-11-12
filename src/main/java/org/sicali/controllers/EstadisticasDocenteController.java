package org.sicali.controllers;

import org.sicali.config.DatabaseConfig;
import org.sicali.models.EstadisticasDocente;
import org.sicali.services.EstadisticasDocenteService;
import io.javalin.http.Context;
import java.sql.Connection;
import java.util.List;

public class EstadisticasDocenteController {

    public static void obtenerPorDocente(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int idDocente = Integer.parseInt(ctx.pathParam("idDocente"));
            EstadisticasDocenteService service = new EstadisticasDocenteService(conn);
            List<EstadisticasDocente> estadisticas = service.obtenerEstadisticasPorDocente(idDocente);
            ctx.json(estadisticas);
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }
}