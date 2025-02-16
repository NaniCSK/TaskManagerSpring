package org.example.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.taskmanager.entities.NoteEntity;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CreateNotesResponseDTO {

    public Integer taskId;
    public NoteEntity notes;
}
