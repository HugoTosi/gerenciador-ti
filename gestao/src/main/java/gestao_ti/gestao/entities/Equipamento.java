package gestao_ti.gestao.entities;

import gestao_ti.gestao.enums.EnumStatusEquipamento;
import gestao_ti.gestao.enums.EnumTipoEquipamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Entity
@Table(name = "equipamento_tb")
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank
    private String cod_patrimonio;

    private String nome;

    @Enumerated(EnumType.STRING)
    private EnumTipoEquipamento tipo_equipamento;

    @Enumerated(EnumType.STRING)
    private EnumStatusEquipamento status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCod_patrimonio() {
        return cod_patrimonio;
    }

    public void setCod_patrimonio(String cod_patrimonio) {
        this.cod_patrimonio = cod_patrimonio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnumTipoEquipamento getTipo_equipamento() {
        return tipo_equipamento;
    }

    public void setTipo_equipamento(EnumTipoEquipamento tipo_equipamento) {
        this.tipo_equipamento = tipo_equipamento;
    }

    public EnumStatusEquipamento getStatus() {
        return status;
    }

    public void setStatus(EnumStatusEquipamento status) {
        this.status = status;
    }
}
