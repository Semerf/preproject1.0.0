package main.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String userName;

    public User(UserPostDto userPostDto) {
        this.firstName = userPostDto.getFirstName();
        this.lastName = userPostDto.getLastName();
        this.email = userPostDto.getEmail();
        this.userName = userPostDto.getUserName();
    }

    public void update(UserPostDto userPostDto) {
        this.firstName = userPostDto.getFirstName();
        this.lastName = userPostDto.getLastName();
        this.email = userPostDto.getEmail();
        this.userName = userPostDto.getUserName();
    }
}
