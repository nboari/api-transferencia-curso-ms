package ar.com.bna.apitransferenciascursoms.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import ar.com.bna.apitransferenciascursoms.configurations.ConfigurationLoad;
import ar.com.bna.apitransferenciascursoms.entity.Cliente;
import ar.com.bna.apitransferenciascursoms.model.ClienteResponse;
import ar.com.bna.apitransferenciascursoms.repository.IClienteRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CienteService implements IClienteService {

    @Autowired
    private ConfigurationLoad config;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public Boolean esCliente(String cuil) {

        log.info("Entro al servicio de cliente con cuil " + cuil);

        ResponseEntity<ArrayList<ClienteResponse>> response;

        Cliente cache = checkCache(cuil);

        if (cache != null)
            return true;

        try {
            response = restTemplate.exchange(
                    buildUrl(config.getApiClienteUrl(), cuil),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<ArrayList<ClienteResponse>>() {
                    });
        } catch (HttpStatusCodeException e) {

            if (e.getStatusCode().value() == HttpStatus.NOT_FOUND.value())
                return false;

            throw e;
        }

        ArrayList<ClienteResponse> cliente = response.getBody();

        if (cliente != null) {
            clienteRepository
                    .save(new Cliente(cliente.get(0).getId(), cliente.get(0).getCuil(), cliente.get(0).getNombre()));
            log.info("Se recupero el cliente del servicio de clientes y se guardo en cache");

            return true;
        } else
            return false;
    }

    private String buildUrl(String getUrl, String cuil) {
        return getUrl + "/?cuil=" + cuil;
    }

    private Cliente checkCache(String cuil) {
        try {
            Optional<Cliente> cliente = clienteRepository.findByCuil(cuil);
            if (cliente.isPresent()) {
                log.info("Se recupero el cliente del cache");
                return cliente.get();
            } else {
                return null;
            }
        } catch (Exception ex) {
            log.error("Error encountered while trying to retrieve client {} check Redis Cache.  Exception {}",
                    cuil, ex);
            return null;
        }
    }
}
