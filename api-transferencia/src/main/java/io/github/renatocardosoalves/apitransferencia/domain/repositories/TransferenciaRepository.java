package io.github.renatocardosoalves.apitransferencia.domain.repositories;

import io.github.renatocardosoalves.apitransferencia.domain.entities.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    @Query("SELECT transferencia FROM Transferencia transferencia WHERE transferencia.origem.numero = :numeroDaConta ORDER BY transferencia.data DESC")
    List<Transferencia> buscarTodasTransferencias(@Param("numeroDaConta") Integer numeroDaConta);
}
