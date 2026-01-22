package com.javanauta.bff_agendador_tarefas.infrastructure.Client;

import com.javanauta.bff_agendador_tarefas.business.DTO.In.EnderecoDTORequest;
import com.javanauta.bff_agendador_tarefas.business.DTO.In.TelefoneDTORequest;
import com.javanauta.bff_agendador_tarefas.business.DTO.In.UsuarioDTORequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name= "usuario", url ="${usuario.url}")
public interface UsuarioClient {

@GetMapping("/usuario")
UsuarioDTORequest buscarUsuarioPorEmail(@RequestParam("email")String email,
                                        @RequestHeader("Authorization")String token);

    @PostMapping
    UsuarioDTORequest salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);


    @PostMapping("/login")
     String login(@RequestBody UsuarioDTORequest usuarioDTO);


    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader("Authorization") String token);




    @PutMapping
    UsuarioDTORequest atualizaDadosUsuario(@RequestBody UsuarioDTORequest dto,
                                           @RequestHeader("Authorization") String token);


    @PutMapping("/endereco")
    EnderecoDTORequest atualizaEndereco(@RequestBody EnderecoDTORequest dto,
                                        @RequestParam("id") Long id,
                                        @RequestHeader("Authorization") String token);


    @PutMapping("/telefone")
    TelefoneDTORequest atualizaTelefone(@RequestBody TelefoneDTORequest dto,
                                        @RequestParam("id") Long id,
                                        @RequestHeader("Authorization") String token);



    @PutMapping("/endereco")
    EnderecoDTORequest cadastraEndereco(@RequestBody EnderecoDTORequest dto,
                                        @RequestHeader("Authorization") String token);



    @PutMapping("/telefone")
    TelefoneDTORequest cadastraTelefone(@RequestBody TelefoneDTORequest dto,
                                        @RequestHeader("Authorization") String token);
}


