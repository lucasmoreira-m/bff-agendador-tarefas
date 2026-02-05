package com.javanauta.bff_agendador_tarefas.infrastructure.exceptions;

public class conflictException extends RuntimeException {
    public conflictException(String mensagem){
        super(mensagem);
    }
    public conflictException(String mensagem, Throwable throwable){
        super(mensagem);
    }
}
