package org.sicali.routes;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.sicali.controllers.GrupoController;
import org.sicali.models.Grupo;
import org.sicali.services.GrupoService;
import org.sicali.config.DatabaseConfig;

import java.sql.Connection;
import java.util.List;

public class GrupoRoutes {

    public static void register(Javalin app) {
        app.get("/api/grupos", GrupoController::obtenerTodos);
        app.get("/api/grupos/{id}", GrupoController::obtenerPorId);
        app.post("/api/grupos", GrupoController::crear);
        app.put("/api/grupos/{id}", GrupoController::actualizar);
        app.delete("/api/grupos/{id}", GrupoController::eliminar);
        app.get("/api/grupos/docente/{idDocente}", GrupoController::obtenerPorDocente);
        app.get("/api/grupos/periodo/{idPeriodo}", GrupoController::obtenerPorPeriodo);
    }

}