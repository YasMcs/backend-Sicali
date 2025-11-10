package org.sicali.repositories;

import org.sicali.models.TutorEstudiante;
import org.sicali.models.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TutorEstudianteRepository {
    private Connection connection;
    private UsuarioRepository usuarioRepository;

    public TutorEstudianteRepository(Connection connection) {
        this.connection = connection;
        this.usuarioRepository = new UsuarioRepository(connection);
    }

    public TutorEstudiante crear(TutorEstudiante tutorEstudiante) throws SQLException {
        String sql = "INSERT INTO tutor_estudiante (id_tutor, id_estudiante) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, tutorEstudiante.getIdTutor().getId_usuario());
            stmt.setInt(2, tutorEstudiante.getIdEstudiante().getId_usuario());
            stmt.executeUpdate();
        }
        return tutorEstudiante;
    }

    public TutorEstudiante obtenerPorIds(int idTutor, int idEstudiante) throws SQLException {
        String sql = "SELECT * FROM tutor_estudiante WHERE id_tutor = ? AND id_estudiante = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idTutor);
            stmt.setInt(2, idEstudiante);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Usuario tutor = usuarioRepository.obtenerPorId(rs.getInt("id_tutor"));
                Usuario estudiante = usuarioRepository.obtenerPorId(rs.getInt("id_estudiante"));
                return new TutorEstudiante(tutor, estudiante);
            }
        }
        return null;
    }

    public List<TutorEstudiante> obtenerTodos() throws SQLException {
        List<TutorEstudiante> tutorEstudiantes = new ArrayList<>();
        String sql = "SELECT * FROM tutor_estudiante";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario tutor = usuarioRepository.obtenerPorId(rs.getInt("id_tutor"));
                Usuario estudiante = usuarioRepository.obtenerPorId(rs.getInt("id_estudiante"));
                tutorEstudiantes.add(new TutorEstudiante(tutor, estudiante));
            }
        }
        return tutorEstudiantes;
    }

    public void eliminar(int idTutor, int idEstudiante) throws SQLException {
        String sql = "DELETE FROM tutor_estudiante WHERE id_tutor = ? AND id_estudiante = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idTutor);
            stmt.setInt(2, idEstudiante);
            stmt.executeUpdate();
        }
    }
}