package ar.com.bna.apitransferenciascursoms.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@Getter
@Builder
@ToString
public class ErrorResponse {
    private int status;
	private String message;
	private String error;
}
