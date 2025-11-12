package org.sicali.routes;

import io.javalin.Javalin;
import org.sicali.controllers.TutorEstudianteController;

public class TutorEstudianteRoutes {
    public static void register(Javalin app) {
        app.get("/api/tutor-estudiantes", TutorEstudianteController::obtenerTodos);
        app.get("/api/tutor-estudiantes/{idTutor}/{idEstudiante}", TutorEstudianteController::obtenerPorIds);
        app.post("/api/tutor-estudiantes", TutorEstudianteController::crear);
        app.delete("/api/tutor-estudiantes/{idTutor}/{idEstudiante}", TutorEstudianteController::eliminar);
        app.get("/api/tutor-estudiantes/tutor/{idTutor}/estudiantes", TutorEstudianteController::obtenerEstudiantesPorTutor);
        app.get("/api/tutor-estudiantes/estudiante/{idEstudiante}/tutores", TutorEstudianteController::obtenerTutoresPorEstudiante);
    }
}
