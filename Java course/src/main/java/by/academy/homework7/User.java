package by.academy.homework7;

import java.util.Objects;

public class User extends Person{

    private String login;
    private String password;
    private String email;

    public User() {
    }

    public User(String firstName, String lastName, int age, String dateOfBirth, String login, String password, String email) {
        super(firstName, lastName, age, dateOfBirth);
        this.login = login;
        this.password = password;
        this.email = email;
    }

    private void printUserInfo(User user){
        System.out.println(user.toString());
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
