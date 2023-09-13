package main.mapper;

import main.models.User;
import main.models.UserPostDto;
import main.models.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public UserResponseDto toUserResponseDto(User user) {
        return new UserResponseDto(user.getFirstName(), user.getLastName(), user.getUserName());
    }

    public User toUser(UserPostDto userPostDto) {
        User user = new User();
        user.setFirstName(userPostDto.getFirstName());
        user.setLastName(userPostDto.getLastName());
        user.setEmail(userPostDto.getEmail());
        user.setUserName(userPostDto.getUserName());
        return user;
    }

    public User updateUser(User user, UserPostDto userPostDto) {
        user.setFirstName(userPostDto.getFirstName());
        user.setLastName(userPostDto.getLastName());
        user.setEmail(userPostDto.getEmail());
        user.setUserName(userPostDto.getUserName());
        return user;
    }
}
