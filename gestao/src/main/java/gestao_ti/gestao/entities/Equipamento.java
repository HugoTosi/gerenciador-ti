package gestao_ti.gestao.entities;

import gestao_ti.gestao.enums.EnumStatusEquipamento;
import gestao_ti.gestao.enums.EnumTipoEquipamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "equipamento_tb")
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cod_patrimonio;

    private String nome;

    @Enumerated(EnumType.STRING)
    private EnumTipoEquipamento tipo_equipamento;

    @Enumerated(EnumType.STRING)
    private EnumStatusEquipamento status;
}
