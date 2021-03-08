package io.github.renatocardosoalves.apitransferencia.api.dtos;

import io.github.renatocardosoalves.apitransferencia.domain.entities.Conta;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

@Data
public class ContaDto {

    private Long idConta;

    private Integer numero;

    private BigDecimal saldo;

    public static Conta toEntity(ContaDto contaDto) {
        return new ModelMapper()
                .map(contaDto, Conta.class);
    }

    public static ContaDto toDto(Conta conta) {
        return new ModelMapper()
                .map(conta, ContaDto.class);
    }
}
