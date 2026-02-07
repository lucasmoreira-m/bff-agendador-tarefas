package com.javanauta.bff_agendador_tarefas.business;

import com.javanauta.bff_agendador_tarefas.business.DTO.In.EnderecoDTORequest;
import com.javanauta.bff_agendador_tarefas.business.DTO.In.LoginResquestDTO;
import com.javanauta.bff_agendador_tarefas.business.DTO.In.TelefoneDTORequest;
import com.javanauta.bff_agendador_tarefas.business.DTO.In.UsuarioDTORequest;
import com.javanauta.bff_agendador_tarefas.business.DTO.Out.ViaCepDTOResponse;
import com.javanauta.bff_agendador_tarefas.infrastructure.Client.UsuarioClient;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;


    public UsuarioDTORequest salvaUsuario(UsuarioDTORequest usuarioDTO) {

        return client.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginResquestDTO dto) {

        return client.login(dto);

    }
    public UsuarioDTORequest buscaUsuarioPorEmail(String email, String token){

        return client.buscarUsuarioPorEmail(email,token);

    }
    public void deletaUsuarioPorEmail(String email, String token){

         deletaUsuarioPorEmail(email,token);

    }
    public UsuarioDTORequest atualizaDadosUsuario(String token, UsuarioDTORequest dto){

        return client.atualizaDadosUsuario(dto,token);

    }


    public EnderecoDTORequest atualizaEndereco(Long idEndereco , String token, EnderecoDTORequest enderecoDTO){

        return client.atualizaEndereco(enderecoDTO,idEndereco,token);

    }

    public TelefoneDTORequest atualizaTelefone(Long idTelefone, TelefoneDTORequest dto, String token){

        return client.atualizaTelefone(dto,idTelefone,token);
    }

    public EnderecoDTORequest cadastraEndereco(String token, EnderecoDTORequest dto){
        return client.cadastraEndereco(dto, token);
    }


    public TelefoneDTORequest cadastraTelefone(String token, TelefoneDTORequest dto){
        return client.cadastraTelefone(dto, token);
    }

    public ViaCepDTOResponse buscarEnderecoPorCep (String cep){
        return client.buscarDadosCep(cep);
    }

}