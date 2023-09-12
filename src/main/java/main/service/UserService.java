package main.service;

import lombok.RequiredArgsConstructor;
import main.models.User;
import main.models.UserPostDto;
import main.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(UserPostDto dto) {
        User user = new User(dto);
        userRepository.save(user);
        return user;
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public void deleteById(Integer id) {
        userRepository.deleteUserById(id);
    }

    public void updateUserById(Integer id, UserPostDto dto) {
        User user = userRepository.findUserById(id);
        user.update(dto);
        userRepository.save(user);
    }
}
