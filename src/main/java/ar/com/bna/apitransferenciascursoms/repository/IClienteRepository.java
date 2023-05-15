package ar.com.bna.apitransferenciascursoms.repository;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.com.bna.apitransferenciascursoms.entity.Cliente;

public interface IClienteRepository extends CrudRepository<Cliente, String> {

    Optional<Cliente> findByCuil(String cuil);
    
}
