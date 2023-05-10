package ar.com.bna.apitransferenciascursoms.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransferenciaRequest {

    @NotBlank
    private String cuilOrigen;

    @NotBlank 
    private String cbuOrigen;

    @NotBlank
    private String cuilDestino;

    @NotBlank
    private String cbuDestino;
        
    @Min(1)
    @Max(150000)
    private Double importe;
    
    @NotBlank
    private String concepto;
    
    @NotBlank
    private String descripcion;
}
