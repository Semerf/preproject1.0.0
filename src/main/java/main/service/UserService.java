package main.service;

import lombok.RequiredArgsConstructor;
import main.mapper.Mapper;
import main.models.User;
import main.models.UserPostDto;
import main.models.UserResponseDto;
import main.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final Mapper mapper = new Mapper();
    private final UserRepository userRepository;

    @Transactional
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(mapper::toUserResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public UserResponseDto addUser(UserPostDto dto) {
        User user = mapper.toUser(dto);
        userRepository.save(user);
        return mapper.toUserResponseDto(user);
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

    @Transactional
    public UserResponseDto updateUserById(Integer id, UserPostDto dto) {
        User user = mapper.updateUser(userRepository.findUserById(id), dto);
        userRepository.save(user);
        return mapper.toUserResponseDto(user);
    }
}
