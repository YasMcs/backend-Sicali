package org.sicali.repositories;

import org.sicali.models.Ciclo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CicloRepository {
    private Connection connection;

    public CicloRepository(Connection connection) {
        this.connection = connection;
    }

    public Ciclo crear(Ciclo ciclo) throws SQLException {
        String sql = "INSERT INTO ciclo (fecha_inicio, fecha_fin) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setDate(1, new java.sql.Date(ciclo.getFechaInicio().getTime()));
            stmt.setDate(2, new java.sql.Date(ciclo.getFechaFin().getTime()));
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                ciclo.setIdCiclo(rs.getInt(1));
            }
        }
        return ciclo;
    }

    public Ciclo obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM ciclo WHERE id_ciclo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Ciclo(
                        rs.getInt("id_ciclo"),
                        rs.getDate("fecha_inicio"),
                        rs.getDate("fecha_fin")
                );
            }
        }
        return null;
    }

    public List<Ciclo> obtenerTodos() throws SQLException {
        List<Ciclo> ciclos = new ArrayList<>();
        String sql = "SELECT * FROM ciclo";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ciclos.add(new Ciclo(
                        rs.getInt("id_ciclo"),
                        rs.getDate("fecha_inicio"),
                        rs.getDate("fecha_fin")
                ));
            }
        }
        return ciclos;
    }

    public void actualizar(Ciclo ciclo) throws SQLException {
        String sql = "UPDATE ciclo SET fecha_inicio = ?, fecha_fin = ? WHERE id_ciclo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(ciclo.getFechaInicio().getTime()));
            stmt.setDate(2, new java.sql.Date(ciclo.getFechaFin().getTime()));
            stmt.setInt(3, ciclo.getIdCiclo());
            stmt.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM ciclo WHERE id_ciclo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}