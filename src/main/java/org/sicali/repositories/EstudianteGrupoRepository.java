package org.sicali.repositories;

import org.sicali.models.EstudianteGrupo;
import org.sicali.models.GrupoAsignatura;
import org.sicali.models.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteGrupoRepository {
    private Connection connection;
    private GrupoAsignaturaRepository grupoAsignaturaRepository;
    private UsuarioRepository usuarioRepository;

    public EstudianteGrupoRepository(Connection connection) {
        this.connection = connection;
        this.grupoAsignaturaRepository = new GrupoAsignaturaRepository(connection);
        this.usuarioRepository = new UsuarioRepository(connection);
    }

    public EstudianteGrupo crear(EstudianteGrupo estudianteGrupo) throws SQLException {
        String sql = "INSERT INTO estudiante_grupo (id_grupoAsignatura, id_estudiante, calificacion) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, estudianteGrupo.getIdGrupoAsignatura().getIdGrupoAsignatura());
            stmt.setInt(2, estudianteGrupo.getIdEstudiante().getId_usuario());
            stmt.setInt(3, estudianteGrupo.getCalificacion());
            stmt.executeUpdate();
        }
        return estudianteGrupo;
    }

    public EstudianteGrupo obtenerPorIds(int idGrupoAsignatura, int idEstudiante) throws SQLException {
        String sql = "SELECT * FROM estudiante_grupo WHERE id_grupoAsignatura = ? AND id_estudiante = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idGrupoAsignatura);
            stmt.setInt(2, idEstudiante);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                GrupoAsignatura grupoAsignatura = grupoAsignaturaRepository.obtenerPorId(rs.getInt("id_grupoAsignatura"));
                Usuario estudiante = usuarioRepository.obtenerPorId(rs.getInt("id_estudiante"));
                return new EstudianteGrupo(
                        grupoAsignatura,
                        estudiante,
                        rs.getInt("calificacion")
                );
            }
        }
        return null;
    }

    public List<EstudianteGrupo> obtenerTodos() throws SQLException {
        List<EstudianteGrupo> estudianteGrupos = new ArrayList<>();
        String sql = "SELECT * FROM estudiante_grupo";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                GrupoAsignatura grupoAsignatura = grupoAsignaturaRepository.obtenerPorId(rs.getInt("id_grupoAsignatura"));
                Usuario estudiante = usuarioRepository.obtenerPorId(rs.getInt("id_estudiante"));
                estudianteGrupos.add(new EstudianteGrupo(
                        grupoAsignatura,
                        estudiante,
                        rs.getInt("calificacion")
                ));
            }
        }
        return estudianteGrupos;
    }

    public void actualizar(EstudianteGrupo estudianteGrupo) throws SQLException {
        String sql = "UPDATE estudiante_grupo SET calificacion = ? WHERE id_grupoAsignatura = ? AND id_estudiante = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, estudianteGrupo.getCalificacion());
            stmt.setInt(2, estudianteGrupo.getIdGrupoAsignatura().getIdGrupoAsignatura());
            stmt.setInt(3, estudianteGrupo.getIdEstudiante().getId_usuario());
            stmt.executeUpdate();
        }
    }

    public void eliminar(int idGrupoAsignatura, int idEstudiante) throws SQLException {
        String sql = "DELETE FROM estudiante_grupo WHERE id_grupoAsignatura = ? AND id_estudiante = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idGrupoAsignatura);
            stmt.setInt(2, idEstudiante);
            stmt.executeUpdate();
        }
    }
}