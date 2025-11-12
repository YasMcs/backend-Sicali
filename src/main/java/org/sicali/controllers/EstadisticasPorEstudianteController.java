package org.sicali.controllers;

import org.sicali.config.DatabaseConfig;
import org.sicali.models.EstadisticasPorEstudiante;
import org.sicali.services.EstadisticasPorEstudianteService;
import io.javalin.http.Context;
import java.sql.Connection;
import java.util.List;

public class EstadisticasPorEstudianteController {

    public static void obtenerPorEstudiante(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int idEstudiante = Integer.parseInt(ctx.pathParam("idEstudiante"));
            EstadisticasPorEstudianteService service = new EstadisticasPorEstudianteService(conn);
            List<EstadisticasPorEstudiante> estadisticas = service.obtenerEstadisticasPorEstudiante(idEstudiante);
            ctx.json(estadisticas);
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }
}