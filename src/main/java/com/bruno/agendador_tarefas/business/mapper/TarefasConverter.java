package com.bruno.agendador_tarefas.business.mapper;

import com.bruno.agendador_tarefas.business.dto.TarefasDTORecord;
import com.bruno.agendador_tarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTORecord dto);

    TarefasDTORecord paraTarefaDTO(TarefasEntity entity);

    List<TarefasEntity> paraListaTarefasEntity(List<TarefasDTORecord> dtos);
    List<TarefasDTORecord> paraListaTarefasDTORecord(List<TarefasEntity> entities);

}
