package gestao_ti.gestao.entities;

import gestao_ti.gestao.enums.EnumStatusColaborador;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "colaborador_tb")
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    @Enumerated(EnumType.STRING)
    private EnumStatusColaborador status;

}
