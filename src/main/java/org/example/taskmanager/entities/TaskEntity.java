package org.example.taskmanager.entities;

import lombok.Data;

import java.util.Date;

@Data
public class TaskEntity {

    private int id;
    private String name;
    private String description;
    private int priority;
    private boolean completed;
    private Date deadline;
}
