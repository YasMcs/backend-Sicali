package org.sicali.services;

import org.sicali.models.Periodo;
import org.sicali.repositories.PeriodoRepository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PeriodoService {
    private PeriodoRepository periodoRepository;

    public PeriodoService(Connection connection) {
        this.periodoRepository = new PeriodoRepository(connection);
    }

    public Periodo crearPeriodo(Periodo periodo) throws SQLException {
        validarPeriodo(periodo);
        return periodoRepository.crear(periodo);
    }

    public Periodo obtenerPeriodoPorId(int id) throws SQLException {
        Periodo periodo = periodoRepository.obtenerPorId(id);
        if (periodo == null) {
            throw new SQLException("Periodo no encontrado con id: " + id);
        }
        return periodo;
    }

    public List<Periodo> obtenerTodosPeriodos() throws SQLException {
        return periodoRepository.obtenerTodos();
    }

    public void actualizarPeriodo(Periodo periodo) throws SQLException {
        validarPeriodo(periodo);
        periodoRepository.actualizar(periodo);
    }

    public void eliminarPeriodo(int id) throws SQLException {
        periodoRepository.eliminar(id);
    }

    public List<Periodo> obtenerPeriodosPorCiclo(int idCiclo) throws SQLException {
        List<Periodo> periodos = periodoRepository.obtenerTodos();
        periodos.removeIf(p -> p.getIdCiclo().getIdCiclo() != idCiclo);
        return periodos;
    }

    private void validarPeriodo(Periodo periodo) throws SQLException {
        if (periodo.getIdCiclo() == null) {
            throw new SQLException("El ciclo es requerido");
        }
    }
}