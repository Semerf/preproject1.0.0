package main.service;

import lombok.RequiredArgsConstructor;
import main.mapper.UserMapper;
import main.entity.User;
import main.model.UserPostDto;
import main.model.UserResponseDto;
import main.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserMapper mapper;

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleService roleService;

    @Transactional(readOnly = true)
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(mapper::toUserResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public UserPostDto addUser(UserPostDto dto) {
        User user = mapper.toUser(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRoles(List.of(roleService.getUserRole()));
        userRepository.save(user);
        return mapper.toUserPostDto(user);
    }

    @Transactional
    public String deleteAll() {
        userRepository.deleteAll();
        return "Пользователи удалены";
    }

    @Transactional
    public String deleteById(Integer id) {
        userRepository.deleteById(id);
        return "Пользователь удален";
    }

    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public UserResponseDto updateUserById(Integer id, UserPostDto dto) {
        User user = mapper.updateUser(userRepository.findUserById(id), dto);
        userRepository.save(user);
        return mapper.toUserResponseDto(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
        );
    }
}
