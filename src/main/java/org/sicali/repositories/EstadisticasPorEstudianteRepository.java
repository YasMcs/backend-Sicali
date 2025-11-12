package org.sicali.repositories;

import org.sicali.models.EstadisticasPorEstudiante;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstadisticasPorEstudianteRepository {
    private Connection connection;

    public EstadisticasPorEstudianteRepository(Connection connection) {
        this.connection = connection;
    }

    public List<EstadisticasPorEstudiante> obtenerEstadisticasPorEstudiante(int idEstudiante) throws SQLException {
        List<EstadisticasPorEstudiante> estadisticas = new ArrayList<>();
        String sql = "SELECT " +
                "u.id_usuario AS id_estudiante, " +
                "u.nombre AS nombre_estudiante, " +
                "u.ape_p AS apellido_paterno, " +
                "u.ape_m AS apellido_materno, " +
                "p.id_periodo, " +
                "CONCAT('Periodo ', p.id_periodo) AS nombre_periodo, " +
                "a.nombre AS nombre_asignatura, " +
                "eg.calificacion, " +
                "ROUND((SUM(CASE WHEN ast.asistencia = 1 THEN 1 ELSE 0 END) * 100.0 / COUNT(ast.id_asistencia)), 2) AS porcentaje_asistencia " +
                "FROM usuario u " +
                "INNER JOIN estudiante_grupo eg ON u.id_usuario = eg.id_estudiante " +
                "INNER JOIN grupo_asignatura ga ON eg.id_grupoAsignatura = ga.id_grupoAsignatura " +
                "INNER JOIN asignatura a ON ga.id_asignatura = a.id_asignatura " +
                "INNER JOIN grupo g ON ga.id_grupo = g.id_grupo " +
                "INNER JOIN periodo p ON g.id_periodo = p.id_periodo " +
                "LEFT JOIN asistencia ast ON u.id_usuario = ast.id_estudiante AND g.id_grupo = ast.id_grupo " +
                "WHERE u.id_usuario = ? " +
                "GROUP BY u.id_usuario, u.nombre, u.ape_p, u.ape_m, p.id_periodo, a.nombre, eg.calificacion";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idEstudiante);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                estadisticas.add(new EstadisticasPorEstudiante(
                        rs.getInt("id_estudiante"),
                        rs.getString("nombre_estudiante"),
                        rs.getString("apellido_paterno"),
                        rs.getString("apellido_materno"),
                        rs.getInt("id_periodo"),
                        rs.getString("nombre_periodo"),
                        rs.getString("nombre_asignatura"),
                        rs.getInt("calificacion"),
                        rs.getDouble("porcentaje_asistencia")
                ));
            }
        }
        return estadisticas;
    }
}