package ru.zmo00.financialReport.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zmo00.financialReport.models.entities.Client;
import ru.zmo00.financialReport.reposirories.ClientRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientDbServiceImpl implements ClientDbService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientDbServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client create(Client client) {
        if (client.getId() == null) {
            client.setId(UUID.randomUUID());
        }
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> read(UUID id) {
        return clientRepository.findById(id);
    }

    @Override
    public Optional<Client> read(String username) {
        return clientRepository.findClientByUsername(username);
    }

    @Override
    public List<Client> readAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client update(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void delete(Client client) {
        clientRepository.delete(client);
    }

    @Override
    public void delete(UUID id) {
        clientRepository.deleteById(id);
    }
}
