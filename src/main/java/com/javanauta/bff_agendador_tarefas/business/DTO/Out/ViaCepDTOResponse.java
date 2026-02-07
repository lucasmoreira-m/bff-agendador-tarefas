package com.javanauta.bff_agendador_tarefas.business.DTO.Out;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViaCepDTOResponse {
    public String cep;
    public String logradouro;
    public String coomplemento;
    public String unidade;
    public String bairro;
    public String localidade;
    public String uf;
    public String estado;
    public String regiao;
    public String ibge;
    public String dia;
    public String ddd;
    public String siafi;
}