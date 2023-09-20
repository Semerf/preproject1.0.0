package main.components;

import lombok.RequiredArgsConstructor;
import main.models.User;
import main.models.UserPostDto;
import main.models.UserResponseDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Mapper {

    public UserResponseDto toUserResponseDto(User user) {
        return new UserResponseDto(user.getFirstName(), user.getLastName(), user.getUsername());
    }

    public UserPostDto toUserPostDto(User user) {
        return new UserPostDto(user.getFirstName(), user.getLastName(), user.getEmail(), user.getUsername(), user.getPassword());
    }

    public User toUser(UserPostDto userPostDto) {
        User user = new User();
        user.setFirstName(userPostDto.getFirstName());
        user.setLastName(userPostDto.getLastName());
        user.setEmail(userPostDto.getEmail());
        user.setUsername(userPostDto.getUsername());
        return user;
    }


    public User updateUser(User user, UserPostDto userPostDto) {
        user.setFirstName(userPostDto.getFirstName());
        user.setLastName(userPostDto.getLastName());
        user.setEmail(userPostDto.getEmail());
        user.setUsername(userPostDto.getUsername());
        return user;
    }
}
