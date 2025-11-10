package org.sicali;

import io.javalin.Javalin;
import org.sicali.routes.*;

public class Main {
    public static void main(String[] args) {

        Javalin app = Javalin.create()
                .start(7000);

        System.out.println("✓ Servidor SICALI iniciado en http://localhost:7000");

        // Registrar rutas
        UsuarioRoutes.register(app);
        CicloRoutes.register(app);
        PeriodoRoutes.register(app);
        AsignaturaRoutes.register(app);
        GrupoRoutes.register(app);
        //GrupoAsignaturaRoutes.register(app);
        //EstudianteGrupoRoutes.register(app);
        //AsistenciaRoutes.register(app);
        //TutorEstudianteRoutes.register(app);

    }
}