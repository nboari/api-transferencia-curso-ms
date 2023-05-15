package ar.com.bna.apitransferenciascursoms.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class ConfigurationLoad {
    @Value("${api.config.cliente.url}")
    private String apiClienteUrl;
    @Value("${redis.server}")
    private String redisServer;
    @Value("${redis.port}")
    private String redisPort;
}
