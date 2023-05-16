package ar.com.bna.apitransferenciascursoms.services.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import ar.com.bna.apitransferenciascursoms.repository.IClienteRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClienteConsumer {

	@Autowired
	private IClienteRepository clienteRedisRepository;

	@KafkaListener(topics = "clienteTopic",
                    groupId = "1")
	public void receiveOrgChange(String clienteId) {
		log.info(String.format("$$ -> Consumed Message-> %s", clienteId));
		try {
			clienteRedisRepository.deleteById(clienteId);
		} catch(Exception e) {}
	}
}
