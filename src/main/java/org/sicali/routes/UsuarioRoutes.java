package org.sicali.routes;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.sicali.models.Usuario;
import org.sicali.services.UsuarioService;
import org.sicali.config.DatabaseConfig;

import java.sql.Connection;
import java.util.List;

public class UsuarioRoutes {

    public static void register(Javalin app) {
        app.get("/api/usuarios", UsuarioRoutes::obtenerTodos);
        app.get("/api/usuarios/{id}", UsuarioRoutes::obtenerPorId);
        app.post("/api/usuarios", UsuarioRoutes::crear);
        app.put("/api/usuarios/{id}", UsuarioRoutes::actualizar);
        app.delete("/api/usuarios/{id}", UsuarioRoutes::eliminar);
    }

    private static void obtenerTodos(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            UsuarioService service = new UsuarioService(conn);
            List<Usuario> usuarios = service.obtenerTodosUsuarios();
            ctx.json(usuarios);
        } catch (Exception e) {
            ctx.status(500).json("Error: " + e.getMessage());
        }
    }

    private static void obtenerPorId(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            UsuarioService service = new UsuarioService(conn);
            Usuario usuario = service.obtenerUsuarioPorId(id);
            ctx.json(usuario);
        } catch (Exception e) {
            ctx.status(404).json("Error: " + e.getMessage());
        }
    }

    private static void crear(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            Usuario usuario = ctx.bodyAsClass(Usuario.class);
            UsuarioService service = new UsuarioService(conn);
            Usuario nuevoUsuario = service.crearUsuario(usuario);
            ctx.status(201).json(nuevoUsuario);
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }

    private static void actualizar(Context ctx) {
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

    private static void eliminar(Context ctx) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            UsuarioService service = new UsuarioService(conn);
            service.eliminarUsuario(id);
            ctx.json("Usuario eliminado");
        } catch (Exception e) {
            ctx.status(400).json("Error: " + e.getMessage());
        }
    }
}