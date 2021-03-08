package io.github.renatocardosoalves.apitransferencia.domain.repositories;

import io.github.renatocardosoalves.apitransferencia.domain.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    Optional<Conta> findByNumero(Integer numero);
}
