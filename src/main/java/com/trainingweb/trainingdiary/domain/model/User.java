package com.trainingweb.trainingdiary.domain.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "first_name")
    @NotEmpty(message = "*Please, provide your name")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "*Please, provide your last name")
    private String lastName;

    @Column(name = "email")
    @Email(message = "*Please, provide a valid email")
    @NotEmpty(message = "*Please, provide your email")
    private String email;

    @Column(name = "password")
    @Length(min = 5, message = "*Your password is too short. It's must have at least 5 characters")
    @NotEmpty(message = "*Please, provide your password")
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Training> trainings;

    public void addRole(Role role) {
        Objects.requireNonNull(role);
        roles.add(role);
    }

    public void addTraining(Training training) {
        Objects.requireNonNull(training);
        trainings.add(training);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }
}