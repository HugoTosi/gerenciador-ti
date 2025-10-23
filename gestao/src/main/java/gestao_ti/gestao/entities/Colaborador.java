package gestao_ti.gestao.entities;

import gestao_ti.gestao.enums.EnumStatusColaborador;
import jakarta.persistence.*;


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

    private String cargo;

    private String setor;

    public Colaborador() {
    }

    public Colaborador(Long id, String nome, String email, String telefone, EnumStatusColaborador status, String cargo, String setor) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.status = status;
        this.cargo = cargo;
        this.setor = setor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public EnumStatusColaborador getStatus() {
        return status;
    }

    public void setStatus(EnumStatusColaborador status) {
        this.status = status;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
