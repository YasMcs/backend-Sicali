package org.sicali.routes;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.sicali.controllers.CicloController;
import org.sicali.models.Ciclo;
import org.sicali.services.CicloService;
import org.sicali.config.DatabaseConfig;

import java.sql.Connection;
import java.util.List;

public class CicloRoutes {

    public static void register(Javalin app) {
        app.get("/api/ciclos", CicloController::obtenerTodos);
        app.get("/api/ciclos/{id}", CicloController::obtenerPorId);
        app.post("/api/ciclos", CicloController::crear);
        app.put("/api/ciclos/{id}", CicloController::actualizar);
        app.delete("/api/ciclos/{id}", CicloController::eliminar);
        app.get("/api/ciclos/activo", CicloController::obtenerActivo);
    }
}