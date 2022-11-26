package ru.zmo00.financialReport.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.zmo00.financialReport.mappers.ClientMapper;
import ru.zmo00.financialReport.models.entities.Client;
import ru.zmo00.financialReport.models.entities.Role;
import ru.zmo00.financialReport.models.entities.Role.RoleEnum;
import ru.zmo00.financialReport.openAPI.model.NewClient;
import ru.zmo00.financialReport.services.db.ClientCrudReactiveService;
import ru.zmo00.financialReport.services.db.RoleDbService;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    private final ClientCrudReactiveService clientCrudReactiveService;
    private final RoleDbService roleDbService;
    private final PasswordEncoder passwordEncoder;
    private final ClientMapper clientMapper;

    @Autowired
    public AuthServiceImpl(ClientCrudReactiveService clientCrudReactiveService, RoleDbService roleDbService,
                           PasswordEncoder passwordEncoder, ClientMapper clientMapper) {
        this.clientCrudReactiveService = clientCrudReactiveService;
        this.roleDbService = roleDbService;
        this.passwordEncoder = passwordEncoder;
        this.clientMapper = clientMapper;
    }

    @Override
    public Mono<Client> userRegisterNewClient(Mono<NewClient> newClientMono) {
        return newClientMono
                .map(newClient -> newClient.setPassword(passwordEncoder.encode("newClient.getPassword()")))
                .map(clientMapper::toClientEntity)
                .
    }
}
