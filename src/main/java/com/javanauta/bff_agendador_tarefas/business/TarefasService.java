package com.javanauta.bff_agendador_tarefas.business;


import com.javanauta.bff_agendador_tarefas.business.DTO.TarefasDTOResponse;
import com.javanauta.bff_agendador_tarefas.business.enums.StatusNotificacaoEnum;
import com.javanauta.bff_agendador_tarefas.infrastructure.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
@Service
public class TarefasService {

    private final TarefasClient tarefasClient;

    public TarefasDTOResponse gravarTarefa(String token, TarefasDTOResponse dto){

        return tarefasClient.gravarTarefas(dto,token);

    }

    public List<TarefasDTOResponse> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                                    LocalDateTime dataFinal,
                                                                    String token ){

return tarefasClient.buscaListaDeTarefasPorPeriodo(dataInicial,dataFinal,token);


    }
    public List<TarefasDTOResponse> buscaTarefasPorEmail(String token) {


        return tarefasClient.buscaTarefasPorEmail(token);
    }

public void deletaTarefaPorId(String id, String token){

    tarefasClient.deletaTarefaPorId(id,token);

            }

        public TarefasDTOResponse alteraStatus(StatusNotificacaoEnum status, String id, String token) {
              return tarefasClient.alteraStatusNotificacao(status, id, token);

        }

        public TarefasDTOResponse upadateTarefas(TarefasDTOResponse dto, String id, String token) {
            return tarefasClient.upadateTarefas(dto, id, token);

        }
    }


