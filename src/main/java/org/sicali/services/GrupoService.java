package org.sicali.services;

import org.sicali.models.Grupo;
import org.sicali.repositories.GrupoRepository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GrupoService {
    private GrupoRepository grupoRepository;

    public GrupoService(Connection connection) {
        this.grupoRepository = new GrupoRepository(connection);
    }

    public Grupo crearGrupo(Grupo grupo) throws SQLException {
        validarGrupo(grupo);
        return grupoRepository.crear(grupo);
    }

    public Grupo obtenerGrupoPorId(int id) throws SQLException {
        Grupo grupo = grupoRepository.obtenerPorId(id);
        if (grupo == null) {
            throw new SQLException("Grupo no encontrado con id: " + id);
        }
        return grupo;
    }

    public List<Grupo> obtenerTodosGrupos() throws SQLException {
        return grupoRepository.obtenerTodos();
    }

    public void actualizarGrupo(Grupo grupo) throws SQLException {
        validarGrupo(grupo);
        grupoRepository.actualizar(grupo);
    }

    public void eliminarGrupo(int id) throws SQLException {
        grupoRepository.eliminar(id);
    }

    public List<Grupo> obtenerGruposPorDocente(int idDocente) throws SQLException {
        List<Grupo> grupos = grupoRepository.obtenerTodos();
        grupos.removeIf(g -> g.getIdDocente().getId_usuario() != idDocente);
        return grupos;
    }

    public List<Grupo> obtenerGruposPorPeriodo(int idPeriodo) throws SQLException {
        List<Grupo> grupos = grupoRepository.obtenerTodos();
        grupos.removeIf(g -> g.getIdPeriodo().getIdPeriodo() != idPeriodo);
        return grupos;
    }

    private void validarGrupo(Grupo grupo) throws SQLException {
        if (grupo.getGrupo() == null || grupo.getGrupo().trim().isEmpty()) {
            throw new SQLException("El nombre del grupo es requerido");
        }
        if (grupo.getGrado() == null || grupo.getGrado().trim().isEmpty()) {
            throw new SQLException("El grado es requerido");
        }
        if (grupo.getIdPeriodo() == null) {
            throw new SQLException("El periodo es requerido");
        }
        if (grupo.getIdDocente() == null) {
            throw new SQLException("El docente es requerido");
        }
    }
}