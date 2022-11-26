package ru.zmo00.financialReport.services.db;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.zmo00.financialReport.models.entities.Client;
import ru.zmo00.financialReport.reposirories.ClientReactiveRepository;

import java.util.UUID;

@Service
public class ClientCrudReactiveServiceDefault implements ClientCrudReactiveService {

    private final ClientReactiveRepository clientReactiveRepository;

    public ClientCrudReactiveServiceDefault(ClientReactiveRepository clientReactiveRepository) {
        this.clientReactiveRepository = clientReactiveRepository;
    }

    @Override
    public Mono<Client> create(Client client) {
        return clientReactiveRepository.save(client);
    }

    @Override
    public Mono<Client> read(UUID id) {
        return clientReactiveRepository.findById(id);
    }

    @Override
    public Mono<Client> read(String username) {
        return clientReactiveRepository.findClientByUsername(username);
    }

    @Override
    public Flux<Client> readAll() {
        return clientReactiveRepository.findAll();
    }

    @Override
    public Mono<Client> update(Client client) {
        return clientReactiveRepository.save(client);
    }

    @Override
    public Mono<Void> delete(Client client) {
        return clientReactiveRepository.delete(client);
    }

    @Override
    public Mono<Void> delete(UUID id) {
        return clientReactiveRepository.deleteById(id);
    }
}
