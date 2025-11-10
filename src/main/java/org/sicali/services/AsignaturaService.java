package org.sicali.services;

import org.sicali.models.Asignatura;
import org.sicali.repositories.AsignaturaRepository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AsignaturaService {
    private AsignaturaRepository asignaturaRepository;

    public AsignaturaService(Connection connection) {
        this.asignaturaRepository = new AsignaturaRepository(connection);
    }

    public Asignatura crearAsignatura(Asignatura asignatura) throws SQLException {
        validarAsignatura(asignatura);
        return asignaturaRepository.crear(asignatura);
    }

    public Asignatura obtenerAsignaturaPorId(int id) throws SQLException {
        Asignatura asignatura = asignaturaRepository.obtenerPorId(id);
        if (asignatura == null) {
            throw new SQLException("Asignatura no encontrada con id: " + id);
        }
        return asignatura;
    }

    public List<Asignatura> obtenerTodasAsignaturas() throws SQLException {
        return asignaturaRepository.obtenerTodos();
    }

    public void actualizarAsignatura(Asignatura asignatura) throws SQLException {
        validarAsignatura(asignatura);
        asignaturaRepository.actualizar(asignatura);
    }

    public void eliminarAsignatura(int id) throws SQLException {
        asignaturaRepository.eliminar(id);
    }

    private void validarAsignatura(Asignatura asignatura) throws SQLException {
        if (asignatura.getNombre() == null || asignatura.getNombre().trim().isEmpty()) {
            throw new SQLException("El nombre de la asignatura es requerido");
        }
        if (asignatura.getCodigo() == null || asignatura.getCodigo().trim().isEmpty()) {
            throw new SQLException("El código de la asignatura es requerido");
        }
    }
}