package ar.com.bna.apitransferenciascursoms.conrtollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.bna.apitransferenciascursoms.model.TransferenciaRequest;
import ar.com.bna.apitransferenciascursoms.model.TransferenciaResponse;
import ar.com.bna.apitransferenciascursoms.services.ITransferenciaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "transferencias", produces = "application/json")
public class TransferenciaController {

    @Autowired
    private ITransferenciaService transferenciaService;
    
    @PostMapping(path = "/", consumes = "application/json")
	public TransferenciaResponse transferir(@Valid @RequestBody TransferenciaRequest request) {
		return transferenciaService.Transferir(request);
	}

}
