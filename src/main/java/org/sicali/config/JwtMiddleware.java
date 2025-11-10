package org.sicali.config;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.Map;

public class JwtMiddleware {
    private final TokenManager tokenManager;

    public JwtMiddleware() {
        this.tokenManager = new TokenManager();
    }

    public Handler validarToken() {
        return ctx -> {
            String authHeader = ctx.header("Authorization");

            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                ctx.status(401).json(Map.of(
                        "error", "Token no proporcionado",
                        "message", "Debe incluir el token en el header Authorization"
                ));
                return;
            }

            String token = authHeader.substring(7); // Remover "Bearer "

            if (!tokenManager.validarToken(token)) {
                ctx.status(401).json(Map.of(
                        "error", "Token inválido o expirado",
                        "message", "Por favor inicie sesión nuevamente"
                ));
                return;
            }

            // Guardar información del usuario en el contexto
            int idUsuario = tokenManager.obtenerIdUsuario(token);
            String rol = tokenManager.obtenerRol(token);

            ctx.attribute("id_usuario", idUsuario);
            ctx.attribute("rol", rol);
        };
    }
    public Handler validarRol(String... rolesPermitidos) {
        return ctx -> {
            String rolUsuario = ctx.attribute("rol");

            boolean tienePermiso = false;
            for (String rol : rolesPermitidos) {
                if (rol.equalsIgnoreCase(rolUsuario)) {
                    tienePermiso = true;
                    break;
                }
            }

            if (!tienePermiso) {
                ctx.status(403).json(Map.of(
                        "error", "Acceso denegado",
                        "message", "No tiene permisos para acceder a este recurso"
                ));
            }
        };
    }
}