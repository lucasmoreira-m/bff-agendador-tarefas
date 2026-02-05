package com.javanauta.bff_agendador_tarefas.business.DTO.Out;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelefoneDTOResponse {

    private String nome;
    private String ddd;
    private String numero;
}
