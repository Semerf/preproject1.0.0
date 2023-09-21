package main.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDto {
    private final String firstName;

    private final String lastName;

    private final String username;
}
