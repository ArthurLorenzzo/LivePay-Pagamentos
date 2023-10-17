package com.br.livepaypag.dto;

import com.br.livepaypag.model.Status;
import com.br.livepaypag.model.TipoDePagamento;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


public record LerPagamentoDTO (Long id,

                               BigDecimal valor,

                               String nome,

                               Status status,

                               TipoDePagamento tipoDePagamento){
}
