package ru.zmo00.financialReport.services.auth;

import reactor.core.publisher.Mono;
import ru.zmo00.financialReport.models.entities.Client;
import ru.zmo00.financialReport.openAPI.model.NewClient;

public interface AuthService {
    Mono<Client> userRegisterNewClient(Mono<NewClient> newClientMono);
}
