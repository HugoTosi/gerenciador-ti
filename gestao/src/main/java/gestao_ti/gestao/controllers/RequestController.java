package gestao_ti.gestao.controllers;

import gestao_ti.gestao.enums.EnumStatusColaborador;
import gestao_ti.gestao.enums.EnumStatusEquipamento;
import gestao_ti.gestao.repositories.ColaboradorRepository;
import gestao_ti.gestao.repositories.EquipamentoRepository;
import gestao_ti.gestao.utils.Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        ret.put("equipamentos", equipamentosDisponiveis);

        return ret;
    }


}
