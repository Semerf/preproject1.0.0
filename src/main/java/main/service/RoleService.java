package main.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import main.entity.Role;
import main.repository.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER");
    }
}