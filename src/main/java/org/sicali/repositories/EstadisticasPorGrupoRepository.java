package org.sicali.repositories;

import org.sicali.models.EstadisticasPorGrupo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstadisticasPorGrupoRepository {
    private Connection connection;

    public EstadisticasPorGrupoRepository(Connection connection) {
        this.connection = connection;
    }

    public List<EstadisticasPorGrupo> obtenerEstadisticasPorGrupo(int idGrupo) throws SQLException {
        List<EstadisticasPorGrupo> estadisticas = new ArrayList<>();
        String sql = "SELECT " +
                "g.id_grupo, " +
                "g.grupo AS nombre_grupo, " +
                "g.grado, " +
                "p.id_periodo, " +
                "CONCAT('Periodo ', p.id_periodo) AS nombre_periodo, " +
                "a.nombre AS nombre_asignatura, " +
                "ROUND(AVG(eg.calificacion), 2) AS promedio_calificaciones, " +
                "COUNT(DISTINCT eg.id_estudiante) AS total_estudiantes, " +
                "ROUND((SUM(CASE WHEN ast.asistencia = 1 THEN 1 ELSE 0 END) * 100.0 / COUNT(ast.id_asistencia)), 2) AS porcentaje_asistencia " +
                "FROM grupo g " +
                "INNER JOIN periodo p ON g.id_periodo = p.id_periodo " +
                "INNER JOIN grupo_asignatura ga ON g.id_grupo = ga.id_grupo " +
                "INNER JOIN asignatura a ON ga.id_asignatura = a.id_asignatura " +
                "INNER JOIN estudiante_grupo eg ON ga.id_grupoAsignatura = eg.id_grupoAsignatura " +
                "LEFT JOIN asistencia ast ON eg.id_estudiante = ast.id_estudiante AND g.id_grupo = ast.id_grupo " +
                "WHERE g.id_grupo = ? " +
                "GROUP BY g.id_grupo, g.grupo, g.grado, p.id_periodo, a.nombre";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idGrupo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                estadisticas.add(new EstadisticasPorGrupo(
                        rs.getInt("id_grupo"),
                        rs.getString("nombre_grupo"),
                        rs.getString("grado"),
                        rs.getInt("id_periodo"),
                        rs.getString("nombre_periodo"),
                        rs.getString("nombre_asignatura"),
                        rs.getDouble("promedio_calificaciones"),
                        rs.getInt("total_estudiantes"),
                        rs.getDouble("porcentaje_asistencia")
                ));
            }
        }
        return estadisticas;
    }
}