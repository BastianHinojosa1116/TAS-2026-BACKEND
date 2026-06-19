package cl.dondevamos.backend.repository;

import cl.dondevamos.backend.entity.EventoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoCategoriaRepository extends JpaRepository<EventoCategoria, Integer> {
}
