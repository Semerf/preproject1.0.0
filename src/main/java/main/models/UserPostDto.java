package main.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserPostDto {

    private final String firstName;

    private final String lastName;

    private final String email;

    private final String userName;

}
