package org.sicali.repositories;

import org.sicali.models.Grupo;
import org.sicali.models.Periodo;
import org.sicali.models.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GrupoRepository {
    private Connection connection;
    private PeriodoRepository periodoRepository;
    private UsuarioRepository usuarioRepository;

    public GrupoRepository(Connection connection) {
        this.connection = connection;
        this.periodoRepository = new PeriodoRepository(connection);
        this.usuarioRepository = new UsuarioRepository(connection);
    }

    public Grupo crear(Grupo grupo) throws SQLException {
        String sql = "INSERT INTO grupo (grupo, grado, id_periodo, id_docente) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, grupo.getGrupo());
            stmt.setString(2, grupo.getGrado());
            stmt.setInt(3, grupo.getIdPeriodo().getIdPeriodo());
            stmt.setInt(4, grupo.getIdDocente().getId_usuario());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                grupo.setIdGrupo(rs.getInt(1));
            }
        }
        return grupo;
    }

    public Grupo obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM grupo WHERE id_grupo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Periodo periodo = periodoRepository.obtenerPorId(rs.getInt("id_periodo"));
                Usuario docente = usuarioRepository.obtenerPorId(rs.getInt("id_docente"));
                return new Grupo(
                        rs.getInt("id_grupo"),
                        rs.getString("grupo"),
                        rs.getString("grado"),
                        periodo,
                        docente
                );
            }
        }
        return null;
    }

    public List<Grupo> obtenerTodos() throws SQLException {
        List<Grupo> grupos = new ArrayList<>();
        String sql = "SELECT * FROM grupo";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Periodo periodo = periodoRepository.obtenerPorId(rs.getInt("id_periodo"));
                Usuario docente = usuarioRepository.obtenerPorId(rs.getInt("id_docente"));
                grupos.add(new Grupo(
                        rs.getInt("id_grupo"),
                        rs.getString("grupo"),
                        rs.getString("grado"),
                        periodo,
                        docente
                ));
            }
        }
        return grupos;
    }

    public void actualizar(Grupo grupo) throws SQLException {
        String sql = "UPDATE grupo SET grupo = ?, grado = ?, id_periodo = ?, id_docente = ? WHERE id_grupo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, grupo.getGrupo());
            stmt.setString(2, grupo.getGrado());
            stmt.setInt(3, grupo.getIdPeriodo().getIdPeriodo());
            stmt.setInt(4, grupo.getIdDocente().getId_usuario());
            stmt.setInt(5, grupo.getIdGrupo());
            stmt.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM grupo WHERE id_grupo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}