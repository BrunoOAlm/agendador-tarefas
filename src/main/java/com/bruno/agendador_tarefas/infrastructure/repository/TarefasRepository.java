package com.bruno.agendador_tarefas.infrastructure.repository;

import com.bruno.agendador_tarefas.infrastructure.entity.TarefasEntity;
import com.bruno.agendador_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import org.springframework.cglib.core.Local;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TarefasRepository extends MongoRepository<TarefasEntity,String> {

    List<TarefasEntity> findByDataEventoBetweenAndStatusNotificacaoEnum(LocalDateTime dataIncial,
                                                                        LocalDateTime dataFinal,
                                                                        StatusNotificacaoEnum status);

    List<TarefasEntity> findByemailUsuario(String email);



}
