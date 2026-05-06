package com.estudos.Eventos.Dto;

import com.estudos.Eventos.Model.StatusEnum;

public record EventoDto(String nome,
                        String descricao,
                        String local,
                        int capacidade,
                        StatusEnum status) {
}
