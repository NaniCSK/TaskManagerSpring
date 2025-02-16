package org.example.taskmanager.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.taskmanager.entities.NoteEntity;
import org.example.taskmanager.entities.TaskEntity;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class TaskResponseDTO {

    private int id;
    private String title;
    private String description;
    private boolean completed;
    private Date deadline;
    private List<NoteEntity> notes;
}
