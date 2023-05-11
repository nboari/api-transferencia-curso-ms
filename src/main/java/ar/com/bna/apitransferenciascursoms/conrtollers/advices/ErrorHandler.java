package ar.com.bna.apitransferenciascursoms.conrtollers.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ar.com.bna.apitransferenciascursoms.exceptions.ClienteNotFoundException;
import ar.com.bna.apitransferenciascursoms.model.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException exception,
			HttpServletRequest request) {
        
		ErrorResponse apiError = ErrorResponse.builder()
            .error(request.getRequestURI() + ": " + "Ocurrió un Error. " + exception.getMessage())
            .message(exception.getMessage())
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
                
		log.error(apiError.toString());

		return new ResponseEntity<ErrorResponse>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ClienteNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFoundException(ClienteNotFoundException exception,
			HttpServletRequest request) {
		
        ErrorResponse apiError = ErrorResponse.builder()
            .error(request.getRequestURI() + ": " + "Ocurrió un Error." + exception.getMessage())
            .message(exception.getMessage())
            .status(HttpStatus.NOT_FOUND.value()).build();
                
		log.error(apiError.toString());

		return new ResponseEntity<ErrorResponse>(apiError, HttpStatus.NOT_FOUND);
	}
    
}
