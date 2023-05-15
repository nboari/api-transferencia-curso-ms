package ar.com.bna.apitransferenciascursoms.entity;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RedisHash("")
public class Cliente {
    @Id
    private int id;
    @Indexed
    private String cuil;
    private String nombre;
}
