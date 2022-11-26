package ru.zmo00.financialReport.reposirories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ru.zmo00.financialReport.models.entities.Client;

import java.util.UUID;

@Repository
public interface ClientReactiveRepository extends ReactiveCrudRepository<Client, UUID> {
    Mono<Client> findClientByUsername(String username);
}
