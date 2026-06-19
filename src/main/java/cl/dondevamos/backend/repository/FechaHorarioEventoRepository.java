package cl.dondevamos.backend.repository;

import cl.dondevamos.backend.entity.FechaHorarioEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FechaHorarioEventoRepository extends JpaRepository<FechaHorarioEvento, Integer> {
}
