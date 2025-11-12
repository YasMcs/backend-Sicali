package org.sicali.controllers;

import org.sicali.config.DatabaseConfig;
import org.sicali.models.TutorEstudiante;
import org.sicali.services.TutorEstudianteService;
import io.javalin.http.Context;
import java.sql.Connection;
import java.util.List;

public class TutorEstudianteController {

    public static void obtenerTodos(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            TutorEstudianteService service = new TutorEstudianteService(conn);
            List<TutorEstudiante> tutorEstudiantes = service.obtenerTodosTutorEstudiantes();
            ctx.json(tutorEstudiantes);
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }

    public static void obtenerPorIds(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int idTutor = Integer.parseInt(ctx.pathParam("idTutor"));
            int idEstudiante = Integer.parseInt(ctx.pathParam("idEstudiante"));
            TutorEstudianteService service = new TutorEstudianteService(conn);
            TutorEstudiante tutorEstudiante = service.obtenerTutorEstudiantePorIds(idTutor, idEstudiante);
            ctx.json(tutorEstudiante);
        } catch (Exception e) {
            ctx.status(404).json("Error: " + e.getMessage());
        }
    }

    public static void crear(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            TutorEstudiante tutorEstudiante = ctx.bodyAsClass(TutorEstudiante.class);
            TutorEstudianteService service = new TutorEstudianteService(conn);
            TutorEstudiante nuevoTutorEstudiante = service.crearTutorEstudiante(tutorEstudiante);
            ctx.status(201).json(nuevoTutorEstudiante);
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    public static void eliminar(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int idTutor = Integer.parseInt(ctx.pathParam("idTutor"));
            int idEstudiante = Integer.parseInt(ctx.pathParam("idEstudiante"));
            TutorEstudianteService service = new TutorEstudianteService(conn);
            service.eliminarTutorEstudiante(idTutor, idEstudiante);
            ctx.json("Relación Tutor-Estudiante eliminada");
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    public static void obtenerEstudiantesPorTutor(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int idTutor = Integer.parseInt(ctx.pathParam("idTutor"));
            TutorEstudianteService service = new TutorEstudianteService(conn);
            List<TutorEstudiante> tutorEstudiantes = service.obtenerEstudiantesPorTutor(idTutor);
            ctx.json(tutorEstudiantes);
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }

    public static void obtenerTutoresPorEstudiante(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int idEstudiante = Integer.parseInt(ctx.pathParam("idEstudiante"));
            TutorEstudianteService service = new TutorEstudianteService(conn);
            List<TutorEstudiante> tutorEstudiantes = service.obtenerTutoresPorEstudiante(idEstudiante);
            ctx.json(tutorEstudiantes);
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }
}