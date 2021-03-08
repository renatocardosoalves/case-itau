package io.github.renatocardosoalves.apitransferencia.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Integer numero;

    private BigDecimal saldo;

    public BigDecimal sacar(BigDecimal valor) {
        this.saldo = this.saldo.subtract(valor);
        return this.saldo;
    }

    public BigDecimal depositar(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
        return this.saldo;
    }

    public Transferencia transferir(Conta destino, BigDecimal valor) {
        this.sacar(valor);
        destino.depositar(valor);

        Transferencia transferencia = new Transferencia();
        transferencia.setOrigem(this);
        transferencia.setDestino(destino);
        transferencia.setValor(valor);

        return transferencia;
    }
}
