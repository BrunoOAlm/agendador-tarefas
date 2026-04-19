package com.bruno.agendador_tarefas.business;

import com.bruno.agendador_tarefas.business.dto.TarefasDTORecord;
import com.bruno.agendador_tarefas.business.mapper.TarefaUpdateConverter;
import com.bruno.agendador_tarefas.business.mapper.TarefasConverter;
import com.bruno.agendador_tarefas.infrastructure.entity.TarefasEntity;
import com.bruno.agendador_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.bruno.agendador_tarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.bruno.agendador_tarefas.infrastructure.repository.TarefasRepository;
import com.bruno.agendador_tarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;
    private final TarefaUpdateConverter tarefaUpdateConverter;

    public TarefasDTORecord gravarTarefa(String token, TarefasDTORecord dto) {
        System.out.println("EMAIL QUE CHEGOU: " + dto.emailUsuario());
        String email = jwtUtil.extrairEmailToken(token.substring(7));


        TarefasDTORecord dtoFinal = new TarefasDTORecord(null,dto.nomeTarefa(),dto.descricao(),LocalDateTime.now(),dto.dataEvento(),email,null,StatusNotificacaoEnum.PENDENTE);
        TarefasEntity entity = tarefasConverter.paraTarefaEntity(dtoFinal);

        return tarefasConverter.paraTarefaDTO(
                tarefasRepository.save(entity));
    }

    public List<TarefasDTORecord> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal) {
        return tarefasConverter.paraListaTarefasDTORecord(tarefasRepository.findByDataEventoBetweenAndStatusNotificacaoEnum(dataInicial, dataFinal,StatusNotificacaoEnum.PENDENTE));

    }

    public List<TarefasDTORecord> buscaTarefasPorEmail(String token) {

        String email = jwtUtil.extrairEmailToken(token.substring(7));
        List<TarefasEntity> listaTarefas = tarefasRepository.findByemailUsuario(email);

        return tarefasConverter.paraListaTarefasDTORecord(listaTarefas);
    }

    public void deletaTarefaPorId(String id) {
        try {


            tarefasRepository.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Erro ao deletar tarefa por id,id inexistente " + id, e.getCause());
        }
    }

    public TarefasDTORecord alterarStatus(StatusNotificacaoEnum status, String id) {
        try {
            TarefasEntity entity = tarefasRepository.findById(id).
                    orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada " + id));
            entity.setStatusNotificacaoEnum(status);
            return tarefasConverter.paraTarefaDTO(tarefasRepository.save(entity));
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Erro ao alterar status da tarefa " + e.getCause());
        }
    }

    public TarefasDTORecord updateTarefas(TarefasDTORecord dto, String id) {
        try {
            TarefasEntity entity = tarefasRepository.findById(id).
                    orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada " + id));
            tarefaUpdateConverter.updateTarefas(dto, entity);
            return tarefasConverter.paraTarefaDTO(tarefasRepository.save(entity));

        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Erro ao alterar status da tarefa " + e.getCause());
        }
    }
}