package io.github.renatocardosoalves.apitransferencia.domain.repositories;

import io.github.renatocardosoalves.apitransferencia.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("select cliente from Cliente cliente inner join Conta conta on cliente.conta.numero = :numero")
    Optional<Cliente> findByConta_Numero(@Param("numero") Integer numero);
}
