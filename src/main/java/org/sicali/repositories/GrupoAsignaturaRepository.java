package org.sicali.repositories;

import org.sicali.models.GrupoAsignatura;
import org.sicali.models.Grupo;
import org.sicali.models.Asignatura;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GrupoAsignaturaRepository {
    private Connection connection;
    private GrupoRepository grupoRepository;
    private AsignaturaRepository asignaturaRepository;

    public GrupoAsignaturaRepository(Connection connection) {
        this.connection = connection;
        this.grupoRepository = new GrupoRepository(connection);
        this.asignaturaRepository = new AsignaturaRepository(connection);
    }

    public GrupoAsignatura crear(GrupoAsignatura grupoAsignatura) throws SQLException {
        String sql = "INSERT INTO grupo_asignatura (id_grupo, id_asignatura) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, grupoAsignatura.getIdGrupo().getIdGrupo());
            stmt.setInt(2, grupoAsignatura.getIdAsignatura().getIdAsignatura());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                grupoAsignatura.setIdGrupoAsignatura(rs.getInt(1));
            }
        }
        return grupoAsignatura;
    }

    public GrupoAsignatura obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM grupo_asignatura WHERE id_grupoAsignatura = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Grupo grupo = grupoRepository.obtenerPorId(rs.getInt("id_grupo"));
                Asignatura asignatura = asignaturaRepository.obtenerPorId(rs.getInt("id_asignatura"));
                return new GrupoAsignatura(
                        rs.getInt("id_grupoAsignatura"),
                        grupo,
                        asignatura
                );
            }
        }
        return null;
    }

    public List<GrupoAsignatura> obtenerTodos() throws SQLException {
        List<GrupoAsignatura> grupoAsignaturas = new ArrayList<>();
        String sql = "SELECT * FROM grupo_asignatura";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Grupo grupo = grupoRepository.obtenerPorId(rs.getInt("id_grupo"));
                Asignatura asignatura = asignaturaRepository.obtenerPorId(rs.getInt("id_asignatura"));
                grupoAsignaturas.add(new GrupoAsignatura(
                        rs.getInt("id_grupoAsignatura"),
                        grupo,
                        asignatura
                ));
            }
        }
        return grupoAsignaturas;
    }

    public void actualizar(GrupoAsignatura grupoAsignatura) throws SQLException {
        String sql = "UPDATE grupo_asignatura SET id_grupo = ?, id_asignatura = ? WHERE id_grupoAsignatura = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, grupoAsignatura.getIdGrupo().getIdGrupo());
            stmt.setInt(2, grupoAsignatura.getIdAsignatura().getIdAsignatura());
            stmt.setInt(3, grupoAsignatura.getIdGrupoAsignatura());
            stmt.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM grupo_asignatura WHERE id_grupoAsignatura = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}