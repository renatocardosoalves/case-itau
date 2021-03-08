package io.github.renatocardosoalves.apitransferencia.api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.renatocardosoalves.apitransferencia.domain.entities.Conta;
import io.github.renatocardosoalves.apitransferencia.domain.entities.Transferencia;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransferenciaDto {

    private Long id;

    private ContaDto origem;

    private ContaDto destino;

    private BigDecimal valor;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDateTime data;

    public static TransferenciaDto toDto(Transferencia transferencia) {
        return new ModelMapper()
                .map(transferencia, TransferenciaDto.class);
    }
}
