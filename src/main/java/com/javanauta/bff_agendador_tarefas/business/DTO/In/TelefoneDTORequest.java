package com.javanauta.bff_agendador_tarefas.business.DTO.In;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelefoneDTORequest {

    private String nome;
    private String ddd;
    private String numero;
}
