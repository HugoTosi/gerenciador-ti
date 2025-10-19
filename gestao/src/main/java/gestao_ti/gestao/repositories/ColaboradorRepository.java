package gestao_ti.gestao.repositories;

import gestao_ti.gestao.entities.Colaborador;
import gestao_ti.gestao.enums.EnumStatusColaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    List<Colaborador> findByStatus(EnumStatusColaborador statusColaborador);
}
