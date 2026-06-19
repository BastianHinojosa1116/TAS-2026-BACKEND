package cl.dondevamos.backend.repository;

import cl.dondevamos.backend.entity.UsuarioApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioAppRepository extends JpaRepository<UsuarioApp, Integer> {
}
