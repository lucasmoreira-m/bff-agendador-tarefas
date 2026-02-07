package com.javanauta.bff_agendador_tarefas.business.DTO.In;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResquestDTO {

    private String email;
    private String senha;
}
