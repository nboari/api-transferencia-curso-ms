package ar.com.bna.apitransferenciascursoms.entity;


import ar.com.bna.apitransferenciascursoms.model.TransferenciaRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "transfers")
public class Transferencia {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String cuilOrigen;

    private String cbuOrigen;

    private String cuilDestino;

    private String cbuDestino;
        
    private Double importe;
    
    private String concepto;
    
    private String descripcion;

    private Boolean applied;

    public Transferencia(TransferenciaRequest request) {
        setCuilOrigen(request.getCuilOrigen());
        setCbuOrigen(request.getCbuOrigen());
        setCuilDestino(request.getCuilDestino());
        setCbuDestino(request.getCbuDestino());
        setImporte(request.getImporte());
        setConcepto(request.getConcepto());
        setDescripcion(request.getDescripcion());
    }

}
