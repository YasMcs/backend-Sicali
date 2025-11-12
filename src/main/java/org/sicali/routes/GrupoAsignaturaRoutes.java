package org.sicali.routes;

import io.javalin.Javalin;
import org.sicali.controllers.EstudianteGrupoController;
import org.sicali.controllers.GrupoAsignaturaController;

public class GrupoAsignaturaRoutes {

    public static void register(Javalin app) {
        app.get("/api/grupo-asignaturas", GrupoAsignaturaController::obtenerTodos);
        app.get("/api/grupo-asignaturas/{id}", GrupoAsignaturaController::obtenerPorId);
        app.post("/api/grupo-asignaturas", GrupoAsignaturaController::crear);
        app.put("/api/grupo-asignaturas/{id}", GrupoAsignaturaController::actualizar);
        app.delete("/api/grupo-asignaturas/{id}", GrupoAsignaturaController::eliminar);
        app.get("/api/grupo-asignaturas/grupo/{idGrupo}", GrupoAsignaturaController::obtenerAsignaturasPorGrupo);
        app.get("/api/grupo-asignaturas/asignatura/{idAsignatura}", GrupoAsignaturaController::obtenerGruposPorAsignatura);

    }
}
