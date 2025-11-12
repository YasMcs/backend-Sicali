package org.sicali.services;

import org.sicali.models.EstadisticasTutor;
import org.sicali.repositories.EstadisticasTutorRepository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EstadisticasTutorService {
    private EstadisticasTutorRepository estadisticasTutorRepository;

    public EstadisticasTutorService(Connection connection) {
        this.estadisticasTutorRepository = new EstadisticasTutorRepository(connection);
    }

    public List<EstadisticasTutor> obtenerEstadisticasPorTutor(int idTutor) throws SQLException {
        if (idTutor <= 0) {
            throw new SQLException("El ID del tutor debe ser mayor a 0");
        }
        return estadisticasTutorRepository.obtenerEstadisticasPorTutor(idTutor);
    }
}