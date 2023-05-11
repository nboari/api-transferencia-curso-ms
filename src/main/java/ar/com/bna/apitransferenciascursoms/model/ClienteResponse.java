package ar.com.bna.apitransferenciascursoms.model;

import lombok.Getter;

@Getter
public class ClienteResponse {
    private Integer id;
	private String nombre;
	private String apellido;
	private String cuil;
	private String tipoDocumento;
	private Integer nroDocumento;
	private boolean esEmpleadoBNA;
	private String paisOrigen;
}
