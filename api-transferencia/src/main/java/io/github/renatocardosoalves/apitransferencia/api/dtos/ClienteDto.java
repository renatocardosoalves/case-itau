package io.github.renatocardosoalves.apitransferencia.api.dtos;

import io.github.renatocardosoalves.apitransferencia.domain.entities.Cliente;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ClienteDto {

    private Long id;

    private String nome;

    private ContaDto conta;

    public static Cliente toEntity(ClienteDto clienteDto) {
        return new ModelMapper()
                .map(clienteDto, Cliente.class);
    }

    public static ClienteDto toDto(Cliente cliente) {
        return new ModelMapper()
                .map(cliente, ClienteDto.class);
    }
}
