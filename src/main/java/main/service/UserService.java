package main.service;

import lombok.RequiredArgsConstructor;
import main.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    public List<User> getAllUsers() {
        //TODO
        return null;
    }

    public User addUser(UserPostDto dto) {
        //TODO
        return null;
    }

    public void deleteAll() {
        //TODO
    }

    public void deleteById(Long id) {
        //TODO
    }

    public void updateUserById(Long id, UserPostDto dto) {
        //TODO
    }
}
