package org.sicali.repositories;

import org.sicali.models.Periodo;
import org.sicali.models.Ciclo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeriodoRepository {
    private Connection connection;
    private CicloRepository cicloRepository;

    public PeriodoRepository(Connection connection) {
        this.connection = connection;
        this.cicloRepository = new CicloRepository(connection);
    }

    public Periodo crear(Periodo periodo) throws SQLException {
        String sql = "INSERT INTO periodo (id_ciclo) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, periodo.getIdCiclo().getIdCiclo());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                periodo.setIdPeriodo(rs.getInt(1));
            }
        }
        return periodo;
    }

    public Periodo obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM periodo WHERE id_periodo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int idCiclo = rs.getInt("id_ciclo");
                Ciclo ciclo = cicloRepository.obtenerPorId(idCiclo);
                return new Periodo(rs.getInt("id_periodo"), ciclo);
            }
        }
        return null;
    }

    public List<Periodo> obtenerTodos() throws SQLException {
        List<Periodo> periodos = new ArrayList<>();
        String sql = "SELECT * FROM periodo";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int idCiclo = rs.getInt("id_ciclo");
                Ciclo ciclo = cicloRepository.obtenerPorId(idCiclo);
                periodos.add(new Periodo(rs.getInt("id_periodo"), ciclo));
            }
        }
        return periodos;
    }

    public void actualizar(Periodo periodo) throws SQLException {
        String sql = "UPDATE periodo SET id_ciclo = ? WHERE id_periodo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, periodo.getIdCiclo().getIdCiclo());
            stmt.setInt(2, periodo.getIdPeriodo());
            stmt.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM periodo WHERE id_periodo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}