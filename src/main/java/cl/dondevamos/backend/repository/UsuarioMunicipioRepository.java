package cl.dondevamos.backend.repository;

import cl.dondevamos.backend.entity.UsuarioMunicipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioMunicipioRepository extends JpaRepository<UsuarioMunicipio, Integer> {
}
