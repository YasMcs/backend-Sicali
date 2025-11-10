package org.sicali.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenManager {
    private static final String SECRET_KEY = "mi_clave";
    private static final long EXPIRATION_TIME = 86400000;
    private final Key key;

    public TokenManager() {
        this.key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }


    public String generarToken(int idUsuario, String usuario, String rol) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id_usuario", idUsuario);
        claims.put("usuario", usuario);
        claims.put("rol", rol);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(usuario)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }


    public boolean validarToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }


    public Claims obtenerClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public int obtenerIdUsuario(String token) {
        Claims claims = obtenerClaims(token);
        return (int) claims.get("id_usuario");
    }


    public String obtenerRol(String token) {
        Claims claims = obtenerClaims(token);
        return (String) claims.get("rol");
    }
}