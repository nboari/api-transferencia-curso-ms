package ar.com.bna.apitransferenciascursoms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.bna.apitransferenciascursoms.entity.Transferencia;
import ar.com.bna.apitransferenciascursoms.model.TransferenciaRequest;
import ar.com.bna.apitransferenciascursoms.model.TransferenciaResponse;
import ar.com.bna.apitransferenciascursoms.repository.ITransferenciaRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TransferenciaService implements ITransferenciaService{

    @Autowired
    private ITransferenciaRepository trasnferenciaRepository;
    
    @Override
    public TransferenciaResponse Transferir(TransferenciaRequest request) {
        log.info("Inicio Servicio Transferencia para Transferir del CBU " + request.getCbuOrigen() + " al CBU " + request.getCbuDestino());
        
        Transferencia entity = new Transferencia(request);
        
        entity.setApplied(true);
        
        trasnferenciaRepository.save(entity);

        TransferenciaResponse response = new TransferenciaResponse(entity);
        
        log.info("Fin Servicio Transferencia para Transferir con Id " + entity.getId() + " y resultado " + entity.getApplied());
        
        return response;
    }
    
}
