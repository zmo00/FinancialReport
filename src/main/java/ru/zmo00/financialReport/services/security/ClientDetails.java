package ru.zmo00.financialReport.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.zmo00.financialReport.models.entities.Client;
import ru.zmo00.financialReport.models.entities.Role;
import ru.zmo00.financialReport.services.db.ClientDbService;
import ru.zmo00.financialReport.services.db.RoleDbServiceImpl;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;

@Service
public class ClientDetails implements ReactiveUserDetailsService {
    private final ClientDbService clientDbService;
    private final RoleDbServiceImpl roleDbService;
    private final PasswordEncoder passwordEncoder;
    private final String userPassword;
    private final String adminPassword;

    @Autowired
    public ClientDetails(ClientDbService clientDbService, RoleDbServiceImpl roleDbService,
                         PasswordEncoder passwordEncoder,
                         @Value("${db.init.user.password}") String userPassword,
                         @Value("${db.init.admin.password}") String adminPassword) {
        this.clientDbService = clientDbService;
        this.roleDbService = roleDbService;
        this.passwordEncoder = passwordEncoder;
        this.userPassword = userPassword;
        this.adminPassword = adminPassword;
    }


    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return Mono.justOrEmpty(clientDbService.read(username));
    }

    @PostConstruct
    public void createInitClients() {
        Client user = Client.builder()
                .username("user")
                .password(passwordEncoder.encode(userPassword))
                .firstname("Mike")
                .lastname("Zhurikov")
                .birthdate(LocalDate.of(2000, 11, 10))
                .gender(Client.Gender.MALE)
                .build();
        Client admin = Client.builder()
                .username("admin")
                .password(passwordEncoder.encode(adminPassword))
                .firstname("Mike")
                .lastname("Zhurikov")
                .birthdate(LocalDate.of(2000, 11, 10))
                .gender(Client.Gender.MALE)
                .build();
        Role userRole = new Role(Role.RoleEnum.CLIENT);
        Role adminRole = new Role(Role.RoleEnum.ADMIN);

        userRole.setClients(List.of(user, admin));
        adminRole.setClients(List.of(admin));

        user.setRoles(List.of(userRole));
        admin.setRoles(List.of(userRole, adminRole));

        roleDbService.create(userRole);
        roleDbService.create(adminRole);
        clientDbService.create(user);
        clientDbService.create(admin);
    }
}
