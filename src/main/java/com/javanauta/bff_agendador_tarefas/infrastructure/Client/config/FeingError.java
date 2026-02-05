package com.javanauta.bff_agendador_tarefas.infrastructure.Client.config;

import com.javanauta.bff_agendador_tarefas.infrastructure.exceptions.BusinessException;
import com.javanauta.bff_agendador_tarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.javanauta.bff_agendador_tarefas.infrastructure.exceptions.UnauthorizedException;
import com.javanauta.bff_agendador_tarefas.infrastructure.exceptions.conflictException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeingError implements ErrorDecoder {


    @Override
    public Exception decode(String s, Response response) {

        switch (response.status()){
            case 409:
                return new conflictException("Erro atributo já existente");
            case 403:
                return new ResourceNotFoundException("Erro atributo não encontrado");
            case 401:
                return new UnauthorizedException("Erro usuário não autorizado");
            default:
                return new BusinessException("Erro de servidor");
        }
    }
}
