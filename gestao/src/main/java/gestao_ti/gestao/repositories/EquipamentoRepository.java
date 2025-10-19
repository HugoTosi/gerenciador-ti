package gestao_ti.gestao.repositories;

import gestao_ti.gestao.entities.Equipamento;
import gestao_ti.gestao.enums.EnumStatusEquipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

    @Query("SELECT COUNT(*) FROM Equipamento WHERE status IN (:status)")
    int getEquipamentosByStatus(@Param("status") List<EnumStatusEquipamento> statusEquipamentos);

    List<Equipamento> findByStatus(EnumStatusEquipamento statusEquipamento);


}
