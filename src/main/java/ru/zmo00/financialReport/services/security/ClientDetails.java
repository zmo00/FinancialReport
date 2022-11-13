package ru.zmo00.financialReport.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.zmo00.financialReport.services.db.ClientDbService;

@Service
public class ClientDetails implements ReactiveUserDetailsService {

    private final ClientDbService clientDbService;

    @Autowired
    public ClientDetails(ClientDbService clientDbService) {
        this.clientDbService = clientDbService;
    }


    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return Mono.justOrEmpty(clientDbService.read(username));
    }
}
