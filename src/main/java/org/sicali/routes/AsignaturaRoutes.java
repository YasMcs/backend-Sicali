package org.sicali.routes;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.sicali.controllers.AsignaturaController;
import org.sicali.models.Asignatura;
import org.sicali.services.AsignaturaService;
import org.sicali.config.DatabaseConfig;

import java.sql.Connection;
import java.util.List;

public class AsignaturaRoutes {

    public static void register(Javalin app) {
        app.get("/api/asignaturas", AsignaturaController::obtenerTodas);
        app.get("/api/asignaturas/{id}", AsignaturaController::obtenerPorId);
        app.post("/api/asignaturas", AsignaturaController::crear);
        app.put("/api/asignaturas/{id}", AsignaturaController::actualizar);
        app.delete("/api/asignaturas/{id}", AsignaturaController::eliminar);
    }
}