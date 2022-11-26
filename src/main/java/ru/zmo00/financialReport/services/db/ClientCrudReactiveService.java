package ru.zmo00.financialReport.services.db;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.zmo00.financialReport.models.entities.Client;

import java.util.UUID;

public interface ClientCrudReactiveService {
    Mono<Client> create(Client client);
    Mono<Client> read(UUID id);
    Mono<Client> read(String username);
    Flux<Client> readAll();
    Mono<Client> update(Client client);
    Mono<Void> delete(Client client);
    Mono<Void> delete(UUID id);
}
