package org.sicali.routes;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.sicali.controllers.PeriodoController;
import org.sicali.models.Periodo;
import org.sicali.services.PeriodoService;
import org.sicali.config.DatabaseConfig;

import java.sql.Connection;
import java.util.List;

public class PeriodoRoutes {

    public static void register(Javalin app) {
        app.get("/api/periodos", PeriodoController::obtenerTodos);
        app.get("/api/periodos/{id}", PeriodoController::obtenerPorId);
        app.post("/api/periodos", PeriodoController::crear);
        app.put("/api/periodos/{id}", PeriodoController::actualizar);
        app.delete("/api/periodos/{id}", PeriodoController::eliminar);
        app.get("/api/periodos/ciclo/{idCiclo}", PeriodoController::obtenerPorCiclo);
    }

}