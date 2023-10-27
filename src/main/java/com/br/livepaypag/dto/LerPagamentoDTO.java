package com.br.livepaypag.dto;

import com.br.livepaypag.model.Status;
import com.br.livepaypag.model.TipoDePagamento;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class LerPagamentoDTO {

    private Long id;

    private BigDecimal valor;

    private String email;

    private Status status;

    private TipoDePagamento tipoDePagamento;

}
