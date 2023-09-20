package main.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import main.models.Role;
import main.repositories.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER");
    }
}