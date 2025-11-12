package org.sicali.repositories;

import org.sicali.models.EstadisticasTutor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstadisticasTutorRepository {
    private Connection connection;

    public EstadisticasTutorRepository(Connection connection) {
        this.connection = connection;
    }

    public List<EstadisticasTutor> obtenerEstadisticasPorTutor(int idTutor) throws SQLException {
        List<EstadisticasTutor> estadisticas = new ArrayList<>();
        String sql = "SELECT " +
                "te.id_tutor, " +
                "te.id_estudiante, " +
                "u.nombre AS nombre_estudiante, " +
                "u.ape_p AS apellido_paterno, " +
                "u.ape_m AS apellido_materno, " +
                "g.id_grupo, " +
                "g.grupo AS nombre_grupo, " +
                "g.grado, " +
                "p.id_periodo, " +
                "CONCAT('Periodo ', p.id_periodo) AS nombre_periodo, " +
                "a.nombre AS nombre_asignatura, " +
                "eg.calificacion, " +
                "ROUND((SUM(CASE WHEN ast.asistencia = 1 THEN 1 ELSE 0 END) * 100.0 / COUNT(ast.id_asistencia)), 2) AS porcentaje_asistencia " +
                "FROM tutor_estudiante te " +
                "INNER JOIN usuario u ON te.id_estudiante = u.id_usuario " +
                "INNER JOIN estudiante_grupo eg ON te.id_estudiante = eg.id_estudiante " +
                "INNER JOIN grupo_asignatura ga ON eg.id_grupoAsignatura = ga.id_grupoAsignatura " +
                "INNER JOIN grupo g ON ga.id_grupo = g.id_grupo " +
                "INNER JOIN periodo p ON g.id_periodo = p.id_periodo " +
                "INNER JOIN asignatura a ON ga.id_asignatura = a.id_asignatura " +
                "LEFT JOIN asistencia ast ON te.id_estudiante = ast.id_estudiante AND g.id_grupo = ast.id_grupo " +
                "WHERE te.id_tutor = ? " +
                "GROUP BY te.id_tutor, te.id_estudiante, u.nombre, u.ape_p, u.ape_m, " +
                "g.id_grupo, g.grupo, g.grado, p.id_periodo, a.nombre, eg.calificacion";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idTutor);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                estadisticas.add(new EstadisticasTutor(
                        rs.getInt("id_tutor"),
                        rs.getInt("id_estudiante"),
                        rs.getString("nombre_estudiante"),
                        rs.getString("apellido_paterno"),
                        rs.getString("apellido_materno"),
                        rs.getInt("id_grupo"),
                        rs.getString("nombre_grupo"),
                        rs.getString("grado"),
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