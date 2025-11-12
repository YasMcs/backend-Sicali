package org.sicali.controllers;

import org.sicali.config.DatabaseConfig;
import org.sicali.models.EstadisticasPorGrupo;
import org.sicali.services.EstadisticasPorGrupoService;
import io.javalin.http.Context;
import java.sql.Connection;
import java.util.List;

public class EstadisticasPorGrupoController {

    public static void obtenerPorGrupo(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int idGrupo = Integer.parseInt(ctx.pathParam("idGrupo"));
            EstadisticasPorGrupoService service = new EstadisticasPorGrupoService(conn);
            List<EstadisticasPorGrupo> estadisticas = service.obtenerEstadisticasPorGrupo(idGrupo);
            ctx.json(estadisticas);
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }
}