package ar.com.bna.apitransferenciascursoms.repository;

import org.springframework.data.repository.CrudRepository;

import ar.com.bna.apitransferenciascursoms.entity.Transferencia;

public interface ITransferenciaRepository extends CrudRepository<Transferencia, Long> {
    
}
