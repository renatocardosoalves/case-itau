package io.github.renatocardosoalves.apitransferencia.api.controllers;

import io.github.renatocardosoalves.apitransferencia.api.dtos.ClienteDto;
import io.github.renatocardosoalves.apitransferencia.domain.services.ClienteService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @ApiOperation(value = "Cadastro de clientes")
    @PostMapping
    public ResponseEntity<ClienteDto> cadastrar(@RequestBody ClienteDto clienteDto, UriComponentsBuilder uriComponentsBuilder) {
        ClienteDto clienteCadastrado = this.clienteService.cadastrar(clienteDto);

        URI uri = uriComponentsBuilder.path("/{id}")
                .buildAndExpand(clienteCadastrado.getId())
                .toUri();

        return ResponseEntity.created(uri).body(clienteCadastrado);
    }

    @ApiOperation(value = "Lista todos os clientes cadastrados")
    @GetMapping
    public ResponseEntity<List<ClienteDto>> listarTodos() {
        List<ClienteDto> todosOsClientes = this.clienteService.listarTodos();
        return ResponseEntity.ok(todosOsClientes);
    }

    @ApiOperation(value = "Busca um cliente pelo numero da conta")
    @GetMapping("/conta/{numeroDaConta}")
    public ResponseEntity<ClienteDto> buscarPeloNumeroDaConta(@PathVariable Integer numeroDaConta) {
        ClienteDto clienteEncontrado = this.clienteService.buscarPeloNumeroDaConta(numeroDaConta);
        return ResponseEntity.ok(clienteEncontrado);
    }
}
