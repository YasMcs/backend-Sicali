package org.sicali.services;

import org.sicali.models.GrupoAsignatura;
import org.sicali.repositories.GrupoAsignaturaRepository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GrupoAsignaturaService {
    private GrupoAsignaturaRepository grupoAsignaturaRepository;

    public GrupoAsignaturaService(Connection connection) {
        this.grupoAsignaturaRepository = new GrupoAsignaturaRepository(connection);
    }

    public GrupoAsignatura crearGrupoAsignatura(GrupoAsignatura grupoAsignatura) throws SQLException {
        validarGrupoAsignatura(grupoAsignatura);
        return grupoAsignaturaRepository.crear(grupoAsignatura);
    }

    public GrupoAsignatura obtenerGrupoAsignaturaPorId(int id) throws SQLException {
        GrupoAsignatura grupoAsignatura = grupoAsignaturaRepository.obtenerPorId(id);
        if (grupoAsignatura == null) {
            throw new SQLException("Grupo-Asignatura no encontrado con id: " + id);
        }
        return grupoAsignatura;
    }

    public List<GrupoAsignatura> obtenerTodosGrupoAsignaturas() throws SQLException {
        return grupoAsignaturaRepository.obtenerTodos();
    }

    public void actualizarGrupoAsignatura(GrupoAsignatura grupoAsignatura) throws SQLException {
        validarGrupoAsignatura(grupoAsignatura);
        grupoAsignaturaRepository.actualizar(grupoAsignatura);
    }

    public void eliminarGrupoAsignatura(int id) throws SQLException {
        grupoAsignaturaRepository.eliminar(id);
    }

    public List<GrupoAsignatura> obtenerAsignaturasPorGrupo(int idGrupo) throws SQLException {
        List<GrupoAsignatura> grupoAsignaturas = grupoAsignaturaRepository.obtenerTodos();
        grupoAsignaturas.removeIf(ga -> ga.getIdGrupo().getIdGrupo() != idGrupo);
        return grupoAsignaturas;
    }

    public List<GrupoAsignatura> obtenerGruposPorAsignatura(int idAsignatura) throws SQLException {
        List<GrupoAsignatura> grupoAsignaturas = grupoAsignaturaRepository.obtenerTodos();
        grupoAsignaturas.removeIf(ga -> ga.getIdAsignatura().getIdAsignatura() != idAsignatura);
        return grupoAsignaturas;
    }

    private void validarGrupoAsignatura(GrupoAsignatura grupoAsignatura) throws SQLException {
        if (grupoAsignatura.getIdGrupo() == null) {
            throw new SQLException("El grupo es requerido");
        }
        if (grupoAsignatura.getIdAsignatura() == null) {
            throw new SQLException("La asignatura es requerida");
        }
    }
}