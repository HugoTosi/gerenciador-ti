package gestao_ti.gestao.controllers;

import gestao_ti.gestao.entities.Equipamento;
import gestao_ti.gestao.enums.EnumStatusEquipamento;
import gestao_ti.gestao.repositories.EquipamentoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamento")
public class EquipamentoController {

    @Autowired
    EquipamentoRepository equipamentoRepository;

    @GetMapping("/getEquipamentos")
    public List<Equipamento> getEquipamentos() {
        return equipamentoRepository.findAllByStatusNot(EnumStatusEquipamento.DESCARTADO);
    }

    @GetMapping("/getEquipamentosDescartados")
    public List<Equipamento> getEquipamentosInativos() {
        return equipamentoRepository.findByStatusOrderByNomeAsc(EnumStatusEquipamento.DESCARTADO);
    }

    @GetMapping("/getEquipamentoById/{id}")
    public ResponseEntity<Equipamento> getEquipamentoById(@PathVariable("id") Long id) {
        return equipamentoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/adicionarEquipamento")
    public ResponseEntity<?> adicionarEquipamento(@Valid @RequestBody Equipamento equipamento) {
        try {
            equipamentoRepository.save(equipamento);
            return ResponseEntity.ok("Equipamento salvo com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro: não foi possível processar a requisição.");
        }
    }

    @PutMapping("/atualizarEquipamento/{id}")
    public ResponseEntity<?> atualizarEquipamento(@PathVariable("id") Long id, @RequestBody Equipamento equipamento) {
        try {
            //equipamento.setId(id);
            equipamentoRepository.save(equipamento);
            return ResponseEntity.ok("Equipamento atualizado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro: não foi possível processar a requisição.");
        }
    }

}

