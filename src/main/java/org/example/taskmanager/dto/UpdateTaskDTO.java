package org.example.taskmanager.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UpdateTaskDTO {
    public String description;
    public String deadline;
    public Boolean completed;
}
