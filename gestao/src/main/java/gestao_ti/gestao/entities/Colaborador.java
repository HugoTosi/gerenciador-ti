package gestao_ti.gestao.entities;

import gestao_ti.gestao.enums.EnumStatusColaborador;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;


@Entity
@Table(name = "colaborador_tb")
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres.")
    private String nome;

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail inválido")
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "\\d{10,11}", message = "Telefone deve conter 10 ou 11 dígitos numéricos.")
    private String telefone;

    @Enumerated(EnumType.STRING)
    private EnumStatusColaborador status;

    @CPF
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    private String cargo;

    private String setor;

    private String observacoes;

    public Colaborador(){

    }

    public Colaborador(Long id, String nome, String email, String telefone, EnumStatusColaborador status, String cpf, String cargo, String setor, String observacoes) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.status = status;
        this.cpf = cpf;
        this.cargo = cargo;
        this.setor = setor;
        this.observacoes = observacoes;
    }

    public Colaborador(Long id, String nome, String email, String telefone, EnumStatusColaborador status, String cargo, String setor, String observacoes) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.status = status;
        this.cargo = cargo;
        this.setor = setor;
        this.observacoes = observacoes;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
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
