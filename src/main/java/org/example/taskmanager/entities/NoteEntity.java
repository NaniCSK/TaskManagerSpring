package org.example.taskmanager.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NoteEntity {

    public int id;
    public String title;
    public String description;
}
