package org.example.taskmanager.service;

import lombok.Getter;
import org.example.taskmanager.entities.TaskEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@Service
public class TaskService {

    @Getter
    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int taskId = 1;
    SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd");

    public TaskEntity addTask(String title, String description, String deadline) throws ParseException {
        TaskEntity task = new TaskEntity();
        task.setId(taskId);
        task.setName(title);
        task.setDescription(description);
        task.setDeadline(dateTimeFormat.parse(deadline));
        task.setCompleted(false);
        tasks.add(task);
        taskId++;
        return task;
    }

    public TaskEntity getTaskById(int id) {
        for (TaskEntity task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public TaskEntity updateTask(int id, String description, String deadline, Boolean completed) throws Exception {
        TaskEntity task = getTaskById(id);
        if(task == null) {
            return null;
        }
        if(description != null) {
            task.setDescription(description);
        }
        if(deadline != null) {
            task.setDeadline(dateTimeFormat.parse(deadline));
        }
        if(completed != null) {
            task.setCompleted(completed);
        }
        return task;
    }

}
