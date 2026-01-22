package com.javanauta.bff_agendador_tarefas.infrastructure.Client;


import com.javanauta.bff_agendador_tarefas.business.DTO.TarefasDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name= "Notificação", url ="${Notificação.url}")
public interface EmailClient {

    Void enviaEmail(@RequestBody TarefasDTOResponse dto);


}