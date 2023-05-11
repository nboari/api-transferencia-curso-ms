package ar.com.bna.apitransferenciascursoms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import ar.com.bna.apitransferenciascursoms.configurations.ConfigurationLoad;
import ar.com.bna.apitransferenciascursoms.entity.Transferencia;
import ar.com.bna.apitransferenciascursoms.exceptions.ClienteNotFoundException;
import ar.com.bna.apitransferenciascursoms.model.ClienteResponse;
import ar.com.bna.apitransferenciascursoms.model.TransferenciaRequest;
import ar.com.bna.apitransferenciascursoms.model.TransferenciaResponse;
import ar.com.bna.apitransferenciascursoms.repository.ITransferenciaRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TransferenciaService implements ITransferenciaService{

    @Autowired
    private ITransferenciaRepository trasnferenciaRepository;

    @Autowired
    private IClienteService clienteService;
   
    @Override
    public TransferenciaResponse Transferir(TransferenciaRequest request) {
        log.info("Inicio Servicio Transferencia para Transferir del CBU " + request.getCbuOrigen() + " al CBU " + request.getCbuDestino());
        
        Transferencia entity = new Transferencia(request);
              
        if (!clienteService.esCliente(request.getCuilOrigen()))
            throw new ClienteNotFoundException("No se encontro el cliente con el cuil " + request.getCuilOrigen() + " en el servicio de clientes");        

        if (!clienteService.esCliente(request.getCuilDestino()))
            throw new ClienteNotFoundException("No se encontro el cliente con el cuil " + request.getCuilDestino() + " en el servicio de clientes");
        
        entity.setApplied(true);    

        trasnferenciaRepository.save(entity);

        TransferenciaResponse response = new TransferenciaResponse(entity);
        
        log.info("Fin Servicio Transferencia  para Transferir OK con Id " + entity.getId() + " y resultado " + entity.getApplied());
        
        return response;
    }
}
