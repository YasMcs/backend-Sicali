package org.sicali.services;

import org.sicali.models.EstadisticasPorGrupo;
import org.sicali.repositories.EstadisticasPorGrupoRepository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EstadisticasPorGrupoService {
    private EstadisticasPorGrupoRepository estadisticasPorGrupoRepository;

    public EstadisticasPorGrupoService(Connection connection) {
        this.estadisticasPorGrupoRepository = new EstadisticasPorGrupoRepository(connection);
    }

    public List<EstadisticasPorGrupo> obtenerEstadisticasPorGrupo(int idGrupo) throws SQLException {
        if (idGrupo <= 0) {
            throw new SQLException("El ID del grupo debe ser mayor a 0");
        }
        return estadisticasPorGrupoRepository.obtenerEstadisticasPorGrupo(idGrupo);
    }
}