package org.sicali.controllers;

import org.sicali.models.Usuario;
import org.sicali.services.UsuarioService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(Connection connection) {
        this.usuarioService = new UsuarioService(connection);
    }

    public Usuario crearUsuario(Usuario usuario) {
        try {
            return usuarioService.crearUsuario(usuario);
        } catch (SQLException e) {
            System.err.println("Error al crear usuario: " + e.getMessage());
            return null;
        }
    }

    public Usuario obtenerUsuarioPorId(int id) {
        try {
            return usuarioService.obtenerUsuarioPorId(id);
        } catch (SQLException e) {
            System.err.println("Error al obtener usuario: " + e.getMessage());
            return null;
        }
    }

    public List<Usuario> obtenerTodosUsuarios() {
        try {
            return usuarioService.obtenerTodosUsuarios();
        } catch (SQLException e) {
            System.err.println("Error al obtener usuarios: " + e.getMessage());
            return null;
        }
    }

    public boolean actualizarUsuario(Usuario usuario) {
        try {
            usuarioService.actualizarUsuario(usuario);
            return true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar usuario: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarUsuario(int id) {
        try {
            usuarioService.eliminarUsuario(id);
            return true;
        } catch (SQLException e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
            return false;
        }
    }

    public List<Usuario> obtenerUsuariosPorRol(String rol) {
        try {
            return usuarioService.obtenerUsuariosPorRol(rol);
        } catch (SQLException e) {
            System.err.println("Error al obtener usuarios por rol: " + e.getMessage());
            return null;
        }
    }
}