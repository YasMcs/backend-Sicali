package org.sicali.services;

import org.sicali.models.EstadisticasPorEstudiante;
import org.sicali.repositories.EstadisticasPorEstudianteRepository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EstadisticasPorEstudianteService {
    private EstadisticasPorEstudianteRepository estadisticasPorEstudianteRepository;

    public EstadisticasPorEstudianteService(Connection connection) {
        this.estadisticasPorEstudianteRepository = new EstadisticasPorEstudianteRepository(connection);
    }

    public List<EstadisticasPorEstudiante> obtenerEstadisticasPorEstudiante(int idEstudiante) throws SQLException {
        if (idEstudiante <= 0) {
            throw new SQLException("El ID del estudiante debe ser mayor a 0");
        }
        return estadisticasPorEstudianteRepository.obtenerEstadisticasPorEstudiante(idEstudiante);
    }
}