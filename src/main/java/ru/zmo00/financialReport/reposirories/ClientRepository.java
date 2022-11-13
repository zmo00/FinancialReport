package ru.zmo00.financialReport.reposirories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zmo00.financialReport.models.entities.Client;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
    Optional<Client> findClientByUsername(String username);
}