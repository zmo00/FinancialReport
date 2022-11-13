package ru.zmo00.financialReport.services.db;

import ru.zmo00.financialReport.models.entities.Role;

import java.util.List;
import java.util.Optional;

public interface RoleDbService {
    Role create(Role role);
    Optional<Role> read(Integer id);
    Role read(Role.RoleEnum role);
    List<Role> readAll();
    Role update(Role role);
    void delete(Role role);
    void delete(Integer id);
}
