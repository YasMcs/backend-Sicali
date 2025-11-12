package org.sicali.routes;

import io.javalin.Javalin;
import org.sicali.controllers.AsistenciaController;
import org.sicali.controllers.EstudianteGrupoController;

public class AsistenciaRoutes {

    public static void register(Javalin app) {
        app.get("/api/asistencias", AsistenciaController::obtenerTodos);
        app.get("/api/asistencias/{id}", AsistenciaController::obtenerPorId);
        app.post("/api/asistencias", AsistenciaController::crear);
        app.put("/api/asistencias/{id}", AsistenciaController::actualizar);
        app.get("/api/asistencias/estudiante/{idEstudiante}", AsistenciaController::obtenerPorEstudiante);
        app.get("/api/asistencias/grupo/{idGrupo}", AsistenciaController::obtenerPorGrupo);
        app.get("/api/asistencias/fecha/{fecha}", AsistenciaController::obtenerPorFecha);
        app.get("/api/asistencias/porcentaje/{idEstudiante}/{idGrupo}", AsistenciaController::calcularPorcentajeAsistencia);

    }
}
