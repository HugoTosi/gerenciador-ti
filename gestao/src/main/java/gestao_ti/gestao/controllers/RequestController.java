package gestao_ti.gestao.controllers;

import gestao_ti.gestao.entities.Colaborador;
import gestao_ti.gestao.enums.EnumStatusColaborador;
import gestao_ti.gestao.enums.EnumStatusEquipamento;
import gestao_ti.gestao.repositories.ColaboradorRepository;
import gestao_ti.gestao.repositories.EquipamentoRepository;
import gestao_ti.gestao.utils.Registro;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RequestController {

    @Autowired
    ColaboradorRepository colaboradorRepository;

    @Autowired
    EquipamentoRepository equipamentoRepository;

    @GetMapping("/dashboard")
    public Registro dadosDashboard(){
        Registro ret = new Registro();
        List<EnumStatusEquipamento> statusEquipamentos = new ArrayList<>(List.of(EnumStatusEquipamento.NOVO, EnumStatusEquipamento.DISPONIVEL));
        int totalColaboradores = colaboradorRepository.findByStatus(EnumStatusColaborador.ATIVO).size();
        int equipamentosDisponiveis = equipamentoRepository.getEquipamentosByStatus(statusEquipamentos);
        int equipamentosEmUso = equipamentoRepository.findByStatus(EnumStatusEquipamento.EMPRESTADO).size();

        ret.put("colaboradores", totalColaboradores);
        ret.put("equipamentosDisponiveis", equipamentosDisponiveis);
        ret.put("equipamentosEmUso", equipamentosEmUso);

        return ret;
    }

    @GetMapping("/getColaboradores")
    public List<Colaborador> getColaboradores(){
        return colaboradorRepository.findByStatusOrderByNomeAsc(EnumStatusColaborador.ATIVO);
    }

    @GetMapping("/getColaboradorById/{id}")
    public ResponseEntity<Colaborador> getColaboradorById(@PathVariable("id") Long id){
        return colaboradorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/adicionarColaborador")
    public ResponseEntity<?> adicionarColaborador(@Valid @RequestBody Colaborador colaborador){
        try {
            colaboradorRepository.save(colaborador);
            return ResponseEntity.ok("Salvo");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro. Não foi possível processar a requisição");
        }

    }

    @PatchMapping("/inativarColaborador/{id}")
    public ResponseEntity<?> inativarColaborador(@PathVariable("id") Long id){
        try{
            colaboradorRepository.atualizarStatus(id, EnumStatusColaborador.INATIVO);
            return ResponseEntity.ok("Colaborador Inativado");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Não foi possível inativar o Colaborador");
        }
    }

    @PutMapping("/atualizarColaborador/{id}")
    public ResponseEntity<?> atualizarColaborador(@PathVariable("id") Long id, @RequestBody Colaborador colaborador){
        try{
            colaborador.setId(id);
            colaboradorRepository.save(colaborador);
            return ResponseEntity.ok("Atualizado");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro. Não foi possível processar a requisição");
        }
    }


}
