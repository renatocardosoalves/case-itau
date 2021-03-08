package io.github.renatocardosoalves.apitransferencia.domain.services;

import io.github.renatocardosoalves.apitransferencia.api.dtos.ClienteDto;
import io.github.renatocardosoalves.apitransferencia.domain.entities.Cliente;
import io.github.renatocardosoalves.apitransferencia.domain.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteDto cadastrar(ClienteDto clienteDto) {
        Cliente clienteASerCadastrado = ClienteDto.toEntity(clienteDto);
        Cliente clienteCadastrado = this.clienteRepository.save(clienteASerCadastrado);
        return ClienteDto.toDto(clienteCadastrado);
    }

    public List<ClienteDto> listarTodos() {
        List<Cliente> todosOsClientes = this.clienteRepository.findAll();
        return todosOsClientes.stream()
                .map(ClienteDto::toDto)
                .collect(Collectors.toList());
    }

    public ClienteDto buscarPeloNumeroDaConta(Integer numeroDaConta) {
        Cliente clienteEncontrado = this.clienteRepository.findByConta_Numero(numeroDaConta)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("A conta nº %s não foi encontrada", numeroDaConta)));
        return ClienteDto.toDto(clienteEncontrado);
    }
}
