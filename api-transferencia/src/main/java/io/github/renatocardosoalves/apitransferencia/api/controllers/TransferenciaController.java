package io.github.renatocardosoalves.apitransferencia.api.controllers;

import io.github.renatocardosoalves.apitransferencia.api.dtos.OperacaoTransferenciaDto;
import io.github.renatocardosoalves.apitransferencia.api.dtos.TransferenciaDto;
import io.github.renatocardosoalves.apitransferencia.domain.services.TransferenciaService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    @ApiOperation(value = "Realizar uma transferência entre duas contas")
    @PutMapping
    public ResponseEntity<TransferenciaDto> transferir(@RequestBody OperacaoTransferenciaDto operacaoTransferenciaDto) {
        TransferenciaDto transferenciaRealizada = this.transferenciaService.transferir(operacaoTransferenciaDto);
        return ResponseEntity.ok(transferenciaRealizada);
    }

    @ApiOperation(value = "Listar todas as transferências realizar em uma conta")
    @GetMapping("/{numeroDaConta}")
    public ResponseEntity<List<TransferenciaDto>> listarTodos(@PathVariable Integer numeroDaConta) {
        List<TransferenciaDto> transferenciaRealizadas = this.transferenciaService.listarTodos(numeroDaConta);
        return ResponseEntity.ok(transferenciaRealizadas);
    }
}
