package org.sicali.repositories;

import org.sicali.models.Asignatura;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AsignaturaRepository {
    private Connection connection;

    public AsignaturaRepository(Connection connection) {
        this.connection = connection;
    }

    public Asignatura crear(Asignatura asignatura) throws SQLException {
        String sql = "INSERT INTO asignatura (nombre, codigo, descripcion) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, asignatura.getNombre());
            stmt.setString(2, asignatura.getCodigo());
            stmt.setString(3, asignatura.getDescripcion());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                asignatura.setIdAsignatura(rs.getInt(1));
            }
        }
        return asignatura;
    }

    public Asignatura obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM asignatura WHERE id_asignatura = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Asignatura(
                        rs.getInt("id_asignatura"),
                        rs.getString("nombre"),
                        rs.getString("codigo"),
                        rs.getString("descripcion")
                );
            }
        }
        return null;
    }

    public List<Asignatura> obtenerTodos() throws SQLException {
        List<Asignatura> asignaturas = new ArrayList<>();
        String sql = "SELECT * FROM asignatura";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                asignaturas.add(new Asignatura(
                        rs.getInt("id_asignatura"),
                        rs.getString("nombre"),
                        rs.getString("codigo"),
                        rs.getString("descripcion")
                ));
            }
        }
        return asignaturas;
    }

    public void actualizar(Asignatura asignatura) throws SQLException {
        String sql = "UPDATE asignatura SET nombre = ?, codigo = ?, descripcion = ? WHERE id_asignatura = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, asignatura.getNombre());
            stmt.setString(2, asignatura.getCodigo());
            stmt.setString(3, asignatura.getDescripcion());
            stmt.setInt(4, asignatura.getIdAsignatura());
            stmt.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM asignatura WHERE id_asignatura = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}