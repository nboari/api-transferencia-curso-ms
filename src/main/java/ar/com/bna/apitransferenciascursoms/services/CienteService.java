package ar.com.bna.apitransferenciascursoms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import ar.com.bna.apitransferenciascursoms.configurations.ConfigurationLoad;
import ar.com.bna.apitransferenciascursoms.model.ClienteResponse;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CienteService implements IClienteService {

    @Autowired
    private ConfigurationLoad config;

    @Autowired
	private RestTemplate restTemplate;

    @Override
    public Boolean esCliente(String cuil) {
        try {
            log.info("Entro al servicio de cliente con cuil " + buildUrl(config.getApiClienteUrl(), cuil));
            ResponseEntity<ClienteResponse> cliente = restTemplate
                    .getForEntity(buildUrl(config.getApiClienteUrl(), cuil), ClienteResponse.class);

        } catch (HttpStatusCodeException e) {

            if (e.getStatusCode().value() == HttpStatus.NOT_FOUND.value())
                return false;

            throw e;
        }

        return true;
    }

    private String buildUrl(String getUrl, String cuil) {
        return getUrl + cuil;
    }
}
