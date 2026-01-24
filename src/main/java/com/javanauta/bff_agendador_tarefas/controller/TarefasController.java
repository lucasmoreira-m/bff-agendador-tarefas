package com.javanauta.bff_agendador_tarefas.controller;


import com.javanauta.bff_agendador_tarefas.business.DTO.In.TarefasDTORequest;
import com.javanauta.bff_agendador_tarefas.business.DTO.TarefasDTOResponse;
import com.javanauta.bff_agendador_tarefas.business.TarefasService;
import com.javanauta.bff_agendador_tarefas.business.enums.StatusNotificacaoEnum;
import com.javanauta.bff_agendador_tarefas.infrastructure.Security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Tag(name= "Tarefas", description = "Cadastra Tarefas de usuários")
@SecurityRequirement(name= SecurityConfig.SECURITY_SCHEME)

public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    @Operation(summary = "Salvar TArefas de usuários", description = "Cria um nova tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefa salva com sucesso")
    @ApiResponse(responseCode = "400", description = "Usuário já cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTOResponse> gravarTarefas(@RequestBody TarefasDTORequest dto,
                                                            @RequestHeader(name="Authorization",required = false)String token)
    {
        return ResponseEntity.ok(tarefasService.gravarTarefa(token,dto));
    }

    @GetMapping("/eventos")
    @Operation(summary = "Busca tarefa por periodo", description = "Busca terefas cadastradas por periodo")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefasDTOResponse>> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dataInical,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dataFinal,
            @RequestHeader(name="Authorization",required = false)String token){
                return ResponseEntity.ok(tarefasService.buscaTarefasAgendadasPorPeriodo(dataInical,dataFinal,token));

    }

    @GetMapping
    @Operation(summary = "Busca lista tarefa por email de usuário", description = "Busca terefas cadastradas por usuário")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefasDTOResponse>> buscaTarefasPorEmail(@RequestHeader(name="Authorization",required = false)String token){

        return ResponseEntity.ok(tarefasService.buscaTarefasPorEmail(token));
    }

    @DeleteMapping
    @Operation(summary = "deleta tarefa por id", description = "deleta terefas cadastradas por id")
    @ApiResponse(responseCode = "200", description = "Tarefas deletadas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deletaTarefaPorId(@RequestParam("id")String id,
                                                  @RequestHeader(name="Authorization",required = false)String token){
        tarefasService.deletaTarefaPorId(id,token);
        return ResponseEntity.ok().build();

    }
    @PatchMapping
    @Operation(summary = "altera status dados de tarefa ", description = "altera status dados das terefas cadastradas ")
    @ApiResponse(responseCode = "200", description = "Status da Tarefas alteradas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTOResponse> alteraStatusNotificacao(@RequestParam ("status") StatusNotificacaoEnum status
            , @RequestParam("id")String id, @RequestHeader(name="Authorization",required = false)String token) {
        return ResponseEntity.ok(tarefasService.alteraStatus(status, id, token));

    }
    @PutMapping
    @Operation(summary = "Update de tarefa ", description = "Update de terefas cadastradas ")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTOResponse> upadateTarefas(@RequestBody TarefasDTORequest dto, @RequestParam("id")String id,
                                                             @RequestHeader(name="Authorization",required = false)String token){
        return ResponseEntity.ok(tarefasService.upadateTarefas(dto,id,token));
    }


}