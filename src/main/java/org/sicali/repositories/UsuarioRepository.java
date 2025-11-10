package org.sicali.repositories;

import org.sicali.models.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {
    private Connection connection;

    public UsuarioRepository(Connection connection) {
        this.connection = connection;
    }

    public Usuario crear(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (nombre, ape_p, ape_m, curp, rfc, sexo, usuario, password, rol, habilitado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApe_p());
            stmt.setString(3, usuario.getApe_m());
            stmt.setString(4, usuario.getCurp());
            stmt.setString(5, usuario.getRfc());
            stmt.setString(6, usuario.getSexo());
            stmt.setString(7, usuario.getUsuario());
            stmt.setString(8, usuario.getPassword());
            stmt.setString(9, usuario.getRol());
            stmt.setBoolean(10, usuario.isHabilitado());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                usuario.setId_usuario(rs.getInt(1));
            }
        }
        return usuario;
    }

    public Usuario obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapearUsuario(rs);
            }
        }
        return null;
    }

    public List<Usuario> obtenerTodos() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                usuarios.add(mapearUsuario(rs));
            }
        }
        return usuarios;
    }

    public void actualizar(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuario SET nombre = ?, ape_p = ?, ape_m = ?, curp = ?, rfc = ?, sexo = ?, usuario = ?, password = ?, rol = ?, habilitado = ? WHERE id_usuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApe_p());
            stmt.setString(3, usuario.getApe_m());
            stmt.setString(4, usuario.getCurp());
            stmt.setString(5, usuario.getRfc());
            stmt.setString(6, usuario.getSexo());
            stmt.setString(7, usuario.getUsuario());
            stmt.setString(8, usuario.getPassword());
            stmt.setString(9, usuario.getRol());
            stmt.setBoolean(10, usuario.isHabilitado());
            stmt.setInt(11, usuario.getId_usuario());
            stmt.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private Usuario mapearUsuario(ResultSet rs) throws SQLException {
        return new Usuario(
                rs.getInt("id_usuario"),
                rs.getString("nombre"),
                rs.getString("ape_p"),
                rs.getString("ape_m"),
                rs.getString("curp"),
                rs.getString("rfc"),
                rs.getString("sexo"),
                rs.getString("usuario"),
                rs.getString("password"),
                rs.getString("rol"),
                rs.getBoolean("habilitado")
        );
    }
}