package ru.zmo00.financialReport.reposirories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zmo00.financialReport.models.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
