package main.service;

import lombok.RequiredArgsConstructor;
import main.mapper.Mapper;
import main.models.User;
import main.models.UserPostDto;
import main.models.UserResponseDto;
import main.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final Mapper mapper = new Mapper();
    private final UserRepository userRepository;

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(mapper::toUserResponseDto)
                .collect(Collectors.toList());
    }

    public UserResponseDto addUser(UserPostDto dto) {
        User user = mapper.toUser(dto);
        userRepository.save(user);
        return mapper.toUserResponseDto(user);
    }

    public String deleteAll() {
        userRepository.deleteAll();
        return "Пользователи удалены";
    }

    public String deleteById(Integer id) {
        User user = userRepository.deleteUserById(id);
        return "Пользователь " + mapper.toUserResponseDto(user) + " удален";
    }

    public UserResponseDto updateUserById(Integer id, UserPostDto dto) {
        User user = mapper.updateUser(userRepository.findUserById(id), dto);
        userRepository.save(user);
        return mapper.toUserResponseDto(user);
    }
}
