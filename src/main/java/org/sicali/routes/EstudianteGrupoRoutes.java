package org.sicali.routes;

import io.javalin.Javalin;
import org.sicali.controllers.EstudianteGrupoController;
import org.sicali.controllers.GrupoController;

public class EstudianteGrupoRoutes {

    public static void register(Javalin app) {
        app.get("/api/estudiante-grupos", EstudianteGrupoController::obtenerTodos);
        app.get("/api/estudiante-grupos/{idGrupoAsignatura}/{idEstudiante}", EstudianteGrupoController::obtenerPorIds);
        app.post("/api/estudiante-grupos", EstudianteGrupoController::crear);
        app.put("/api/estudiante-grupos/{idGrupoAsignatura}/{idEstudiante}/calificacion", EstudianteGrupoController::actualizarCalificacion);
        app.delete("/api/estudiante-grupos/{idGrupoAsignatura}/{idEstudiante}", EstudianteGrupoController::eliminar);
        app.get("/api/estudiante-grupos/grupo-asignatura/{idGrupoAsignatura}", EstudianteGrupoController::obtenerEstudiantesPorGrupoAsignatura);
        app.get("/api/estudiante-grupos/estudiante/{idEstudiante}", EstudianteGrupoController::obtenerGruposPorEstudiante);
        app.get("/api/estudiante-grupos/estudiante/{idEstudiante}/promedio", EstudianteGrupoController::calcularPromedioEstudiante);

    }
}
