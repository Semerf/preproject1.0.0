package main.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class UserResponseDto {
    private final String firstName;

    private final String lastName;

    private final String userName;
}
