package ru.zmo00.financialReport.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zmo00.financialReport.models.entities.Role;
import ru.zmo00.financialReport.reposirories.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleDbServiceImpl implements RoleDbService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleDbServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Optional<Role> read(Integer id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role read(Role.RoleEnum role) {
        return roleRepository.findByRole("ROLE_" + role.toString());
    }

    @Override
    public List<Role> readAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role update(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }
}
