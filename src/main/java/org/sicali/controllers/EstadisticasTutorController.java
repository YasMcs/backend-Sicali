package org.sicali.controllers;

import org.sicali.config.DatabaseConfig;
import org.sicali.models.EstadisticasTutor;
import org.sicali.services.EstadisticasTutorService;
import io.javalin.http.Context;
import java.sql.Connection;
import java.util.List;

public class EstadisticasTutorController {

    public static void obtenerPorTutor(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int idTutor = Integer.parseInt(ctx.pathParam("idTutor"));
            EstadisticasTutorService service = new EstadisticasTutorService(conn);
            List<EstadisticasTutor> estadisticas = service.obtenerEstadisticasPorTutor(idTutor);
            ctx.json(estadisticas);
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }
}