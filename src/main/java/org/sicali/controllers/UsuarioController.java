package org.sicali.controllers;

import org.sicali.config.DatabaseConfig;
import org.sicali.models.Usuario;
import org.sicali.services.UsuarioService;
import io.javalin.http.Context;
import java.sql.Connection;
import java.util.List;

public class UsuarioController {

    public static void obtenerTodos(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            UsuarioService service = new UsuarioService(conn);
            List<Usuario> usuarios = service.obtenerTodosUsuarios();
            ctx.json(usuarios);
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }

    public static void obtenerPorId(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            UsuarioService service = new UsuarioService(conn);
            Usuario usuario = service.obtenerUsuarioPorId(id);
            ctx.json(usuario);
        } catch (Exception e) {
            ctx.status(404).json("Error: " + e.getMessage());
        }
    }

    public static void crear(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            Usuario usuario = ctx.bodyAsClass(Usuario.class);
            UsuarioService service = new UsuarioService(conn);
            Usuario nuevoUsuario = service.crearUsuario(usuario);
            ctx.status(201).json(nuevoUsuario);
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    public static void actualizar(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            Usuario usuario = ctx.bodyAsClass(Usuario.class);
            usuario.setId_usuario(id);
            UsuarioService service = new UsuarioService(conn);
            service.actualizarUsuario(usuario);
            ctx.json("Usuario actualizado");
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    public static void eliminar(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            UsuarioService service = new UsuarioService(conn);
            service.eliminarUsuario(id);
            ctx.json("Usuario eliminado");
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    public static void obtenerPorRol(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            String rol = ctx.pathParam("rol");
            UsuarioService service = new UsuarioService(conn);
            List<Usuario> usuarios = service.obtenerUsuariosPorRol(rol);
            ctx.json(usuarios);
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }
}