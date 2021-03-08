package io.github.renatocardosoalves.apitransferencia.domain.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Conta origem;

    @OneToOne
    private Conta destino;

    private BigDecimal valor;

    @CreatedDate
    private LocalDateTime data;
}
