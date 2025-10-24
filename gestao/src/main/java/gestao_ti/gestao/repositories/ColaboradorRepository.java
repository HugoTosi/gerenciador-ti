package gestao_ti.gestao.repositories;

import gestao_ti.gestao.entities.Colaborador;
import gestao_ti.gestao.enums.EnumStatusColaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    List<Colaborador> findByStatus(EnumStatusColaborador statusColaborador);

    List<Colaborador> findByStatusOrderByNomeAsc(EnumStatusColaborador statusColaborador);

    @Transactional
    @Modifying
    @Query("UPDATE Colaborador SET status = :status WHERE id = :id")
    void atualizarStatus(@Param("id") Long id, @Param("status") EnumStatusColaborador enumStatusColaborador);
}
