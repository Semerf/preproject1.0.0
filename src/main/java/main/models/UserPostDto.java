package main.models;

public class UserPostDto {

    private final String firstName;

    private final String lastName;

    private final String email;

    private final String userName;

    public UserPostDto(String firstName, String lastName, String email, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
    }

    public UserPostDto(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.userName = user.getUserName();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }
}
