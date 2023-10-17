package com.br.livepaypag.dto;

import com.br.livepaypag.model.Status;
import com.br.livepaypag.model.TipoDePagamento;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


public record PagamentoDTO(
        Long id,

        BigDecimal valor,

        String nome,

        String numero,

        String expiracao,

        String codigoSeguranca,

        Status status,

        TipoDePagamento tipoDePagamento) {


}
