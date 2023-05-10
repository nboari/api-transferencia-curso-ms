package ar.com.bna.apitransferenciascursoms.model;

import lombok.Getter;
import lombok.Setter;
import ar.com.bna.apitransferenciascursoms.entity.Transferencia;

@Setter
@Getter
public class TransferenciaResponse {
    private long id;    

    private String cbuOrigen;    

    private String cbuDestino;
        
    private Double importe;

    private Boolean applied;

    public TransferenciaResponse(Transferencia entity){
        this.setId(entity.getId());
        this.setCbuDestino(entity.getCbuDestino());
        this.setCbuOrigen(entity.getCbuOrigen());
        this.setImporte(entity.getImporte());
        this.setApplied(entity.getApplied());
    }
}
