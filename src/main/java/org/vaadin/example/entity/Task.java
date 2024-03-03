package org.vaadin.example.entity;

import lombok.*;
import org.vaadin.example.constants.Priority;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {

    private Integer id;

    private String title;

    private String description;

    private Date dueDate;

    private Priority priority;

    private boolean completed;

    private Employee employee;
}
