package com.javanauta.bff_agendador_tarefas.infrastructure.Client;

import com.javanauta.bff_agendador_tarefas.business.DTO.In.TarefasDTORequest;
import com.javanauta.bff_agendador_tarefas.business.DTO.TarefasDTOResponse;
import com.javanauta.bff_agendador_tarefas.business.enums.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@FeignClient(name= "agendador-tarefas", url ="${agendador-tarefas.url}")
public interface TarefasClient {

    @PostMapping
    TarefasDTOResponse gravarTarefas(@RequestBody TarefasDTORequest dto,
                                     @RequestHeader("Authorization")String token);


    @GetMapping("/eventos")
  List<TarefasDTOResponse> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInical,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dataFinal,
            @RequestHeader("Authorization")String token);

    @GetMapping
    List<TarefasDTOResponse> buscaTarefasPorEmail(@RequestHeader("Authorization")String token);


    @DeleteMapping
   void deletaTarefaPorId(@RequestParam("id")String id,
                          @RequestHeader("Authorization")String token);

    @PatchMapping
    TarefasDTOResponse alteraStatusNotificacao(@RequestParam ("status") StatusNotificacaoEnum status
                                     , @RequestParam("id")String id,
                                               @RequestHeader("Authorization")String token);

    @PutMapping
    TarefasDTOResponse upadateTarefas(@RequestBody TarefasDTORequest dto,
                                      @RequestParam("id")String id,
                                      @RequestHeader("Authorization")String token);
    }

