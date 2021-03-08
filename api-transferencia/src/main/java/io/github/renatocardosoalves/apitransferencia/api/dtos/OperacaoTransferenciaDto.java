package io.github.renatocardosoalves.apitransferencia.api.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OperacaoTransferenciaDto {

    private Integer numeroContaOrigem;

    private Integer numeroContaDestino;

    private BigDecimal valor;
}
