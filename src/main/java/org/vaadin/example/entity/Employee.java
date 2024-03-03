package org.vaadin.example.entity;

import lombok.*;
import org.vaadin.example.constants.Role;

import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

    private Integer id;

    @NotEmpty(message = "First name cannot be empty")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    private String lastName;

    @Email(message = "Please enter valid email")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    private String phoneNo;

    @Size(min = 8, message = "Password should consist of 8 digits")
    @NotEmpty(message = "Password cannot be empty")
    private String password;

    private List<Task> task;

    @NotNull(message = "Role cannot be empty")
    private Role role;

    private Employee manager;
}
