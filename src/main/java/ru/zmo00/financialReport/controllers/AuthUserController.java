package ru.zmo00.financialReport.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import ru.zmo00.financialReport.mappers.ClientMapper;
import ru.zmo00.financialReport.openAPI.api.UserApi;
import ru.zmo00.financialReport.openAPI.model.Client;
import ru.zmo00.financialReport.openAPI.model.NewClient;
import ru.zmo00.financialReport.services.auth.AuthService;

@Controller
public class AuthUserController implements UserApi {

    private final AuthService authService;
    private final ClientMapper clientMapper;

    @Autowired
    public AuthUserController(AuthService authService, ClientMapper clientMapper) {
        this.authService = authService;
        this.clientMapper = clientMapper;
    }

    @Override
    public Mono<ResponseEntity<Client>> registerNewClient(Mono<NewClient> newClient, ServerWebExchange exchange) {
        return authService.
    }
}
