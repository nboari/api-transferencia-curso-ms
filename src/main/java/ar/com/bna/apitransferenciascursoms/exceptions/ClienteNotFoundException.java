package ar.com.bna.apitransferenciascursoms.exceptions;

public class ClienteNotFoundException extends RuntimeException {

	public ClienteNotFoundException() {
		
	}
	
	public ClienteNotFoundException(String message) {
		super(message);
	}

	public ClienteNotFoundException(Exception ex) {
		super(ex);
	}
}