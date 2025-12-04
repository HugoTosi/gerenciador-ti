package gestao_ti.gestao.repositories;

import gestao_ti.gestao.entities.Equipamento;
import gestao_ti.gestao.enums.EnumStatusEquipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

    @Query("SELECT COUNT(*) FROM Equipamento WHERE status IN (:status)")
    int getEquipamentosByStatus(@Param("status") List<EnumStatusEquipamento> statusEquipamentos);

    @Query("SELECT e FROM Equipamento e WHERE e.status <> :status")
    List<Equipamento> findAllByStatusNot(@Param("status") EnumStatusEquipamento status);

    List<Equipamento> findByStatus(EnumStatusEquipamento statusEquipamento);

    List<Equipamento> findByStatusOrderByNomeAsc(EnumStatusEquipamento statusEquipamento);

    @Transactional
    @Modifying
    @Query("UPDATE Equipamento SET status = :status WHERE id = :id")
    void atualizarStatus(@Param("id") Long id, @Param("status") EnumStatusEquipamento enumStatusEquipamento);


}
