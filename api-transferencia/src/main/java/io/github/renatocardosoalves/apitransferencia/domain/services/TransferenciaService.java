package io.github.renatocardosoalves.apitransferencia.domain.services;

import io.github.renatocardosoalves.apitransferencia.api.dtos.OperacaoTransferenciaDto;
import io.github.renatocardosoalves.apitransferencia.api.dtos.TransferenciaDto;
import io.github.renatocardosoalves.apitransferencia.domain.entities.Conta;
import io.github.renatocardosoalves.apitransferencia.domain.entities.Transferencia;
import io.github.renatocardosoalves.apitransferencia.domain.repositories.ContaRepository;
import io.github.renatocardosoalves.apitransferencia.domain.repositories.TransferenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TransferenciaService {

    private final ContaRepository contaRepository;

    private final TransferenciaRepository transferenciaRepository;

    public TransferenciaDto transferir(OperacaoTransferenciaDto operacaoTransferenciaDto) {
        Integer numeroContaDeOrigem = operacaoTransferenciaDto.getNumeroContaOrigem();

        Conta contaOrigem = this.contaRepository.findByNumero(numeroContaDeOrigem)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("A conta de origem nº%s não foi encontrada", numeroContaDeOrigem)));

        Integer numeroContaDeDestino = operacaoTransferenciaDto.getNumeroContaDestino();

        Conta contaDestino = this.contaRepository.findByNumero(numeroContaDeDestino)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("A conta de destino nº%s não foi encontrada", numeroContaDeDestino)));

        Transferencia transferenciaRealizada = this.transferenciaRepository.save(contaOrigem.transferir(contaDestino, operacaoTransferenciaDto.getValor()));

        return TransferenciaDto.toDto(transferenciaRealizada);
    }
    
    public List<TransferenciaDto> listarTodos(Integer numeroDaConta) {
        List<Transferencia> todasAsTransferencias = this.transferenciaRepository.buscarTodasTransferencias(numeroDaConta);

        return todasAsTransferencias.stream()
                .map(TransferenciaDto::toDto)
                .collect(Collectors.toList());
    }
}
