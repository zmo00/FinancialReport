package ru.zmo00.financialReport.services.db;

import ru.zmo00.financialReport.models.entities.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientDbService {
    Client create(Client client);
    Optional<Client> read(UUID id);
    Optional<Client> read(String username);
    List<Client> readAll();
    Client update(Client client);
    void delete(Client client);
    void delete(UUID id);
}
