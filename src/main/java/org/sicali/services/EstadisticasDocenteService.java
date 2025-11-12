package org.sicali.services;

import org.sicali.models.EstadisticasDocente;
import org.sicali.repositories.EstadisticasDocenteRepository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EstadisticasDocenteService {
    private EstadisticasDocenteRepository estadisticasDocenteRepository;

    public EstadisticasDocenteService(Connection connection) {
        this.estadisticasDocenteRepository = new EstadisticasDocenteRepository(connection);
    }

    public List<EstadisticasDocente> obtenerEstadisticasPorDocente(int idDocente) throws SQLException {
        if (idDocente <= 0) {
            throw new SQLException("El ID del docente debe ser mayor a 0");
        }
        return estadisticasDocenteRepository.obtenerEstadisticasPorDocente(idDocente);
    }
}