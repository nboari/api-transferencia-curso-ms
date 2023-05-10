package ar.com.bna.apitransferenciascursoms.services;
import ar.com.bna.apitransferenciascursoms.model.TransferenciaRequest;
import ar.com.bna.apitransferenciascursoms.model.TransferenciaResponse;


public interface ITransferenciaService {
    public TransferenciaResponse Transferir(TransferenciaRequest request);
}
