package com.javanauta.bff_agendador_tarefas.business;


import com.javanauta.bff_agendador_tarefas.business.DTO.TarefasDTOResponse;
import com.javanauta.bff_agendador_tarefas.business.enums.StatusNotificacaoEnum;
import com.javanauta.bff_agendador_tarefas.infrastructure.Client.EmailClient;
import com.javanauta.bff_agendador_tarefas.infrastructure.Client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
@Service
public class EmailService {

    private final EmailClient emailClient;

    public void enviaEmail(TarefasDTOResponse dto) {

        emailClient.enviaEmail(dto);

    }

}