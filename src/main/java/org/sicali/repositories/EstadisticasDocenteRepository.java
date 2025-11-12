package org.sicali.repositories;

import org.sicali.models.EstadisticasDocente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstadisticasDocenteRepository {
    private Connection connection;

    public EstadisticasDocenteRepository(Connection connection) {
        this.connection = connection;
    }

    public List<EstadisticasDocente> obtenerEstadisticasPorDocente(int idDocente) throws SQLException {
        List<EstadisticasDocente> estadisticas = new ArrayList<>();
        String sql = "SELECT " +
                "g.id_grupo, " +
                "g.grupo AS nombre_grupo, " +
                "g.grado, " +
                "g.id_docente, " +
                "p.id_periodo, " +
                "CONCAT('Periodo ', p.id_periodo) AS nombre_periodo, " +
                "COUNT(DISTINCT eg.id_estudiante) AS total_estudiantes, " +
                "a.nombre AS nombre_asignatura, " +
                "ROUND(AVG(eg.calificacion), 2) AS promedio_calificacion, " +
                "ROUND((SUM(CASE WHEN ast.asistencia = 1 THEN 1 ELSE 0 END) * 100.0 / COUNT(ast.id_asistencia)), 2) AS porcentaje_asistencia " +
                "FROM grupo g " +
                "INNER JOIN periodo p ON g.id_periodo = p.id_periodo " +
                "INNER JOIN grupo_asignatura ga ON g.id_grupo = ga.id_grupo " +
                "INNER JOIN asignatura a ON ga.id_asignatura = a.id_asignatura " +
                "INNER JOIN estudiante_grupo eg ON ga.id_grupoAsignatura = eg.id_grupoAsignatura " +
                "LEFT JOIN asistencia ast ON eg.id_estudiante = ast.id_estudiante AND g.id_grupo = ast.id_grupo " +
                "WHERE g.id_docente = ? " +
                "GROUP BY g.id_grupo, g.grupo, g.grado, g.id_docente, p.id_periodo, a.nombre";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idDocente);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                estadisticas.add(new EstadisticasDocente(
                        rs.getInt("id_grupo"),
                        rs.getString("nombre_grupo"),
                        rs.getString("grado"),
                        rs.getInt("id_docente"),
                        rs.getInt("id_periodo"),
                        rs.getString("nombre_periodo"),
                        rs.getInt("total_estudiantes"),
                        rs.getString("nombre_asignatura"),
                        rs.getDouble("promedio_calificacion"),
                        rs.getDouble("porcentaje_asistencia")
                ));
            }
        }
        return estadisticas;
    }
}