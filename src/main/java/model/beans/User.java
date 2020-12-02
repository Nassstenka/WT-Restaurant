package model.beans;

import java.util.Objects;

public class User {
    private long id;
    private String role;
    private String name;
    private String surname;
    private String gender;
    private byte yearOld;
    private String email;
    private String password;
    private boolean blocked;

    public User() {

    }

    public User(String role, String name, String surname, String gender, byte yearOld, String email, String password) {
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.yearOld = yearOld;
        this.email = email;
        this.password = password;
    }

    public User(long id, String role, String name, String surname, String gender, byte yearOld, String email, String password, boolean blocked) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.yearOld = yearOld;
        this.email = email;
        this.password = password;
        this.blocked = blocked;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public byte getYearOld() {
        return yearOld;
    }

    public void setYearOld(byte yearOld) {
        this.yearOld = yearOld;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                yearOld == user.yearOld &&
                blocked == user.blocked &&
                role.equals(user.role) &&
                name.equals(user.name) &&
                surname.equals(user.surname) &&
                gender.equals(user.gender) &&
                email.equals(user.email) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, name, surname, gender, yearOld, email, password, blocked);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", yearOld=" + yearOld +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", blocked=" + blocked +
                '}';
    }
}
