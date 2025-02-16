package org.example.taskmanager.controller;

import org.example.taskmanager.dto.CreateTaskDTO;
import org.example.taskmanager.dto.ErrorRespomseDTO;
import org.example.taskmanager.dto.UpdateTaskDTO;
import org.example.taskmanager.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public ResponseEntity<String> getTasks() {

        var tasks = taskService.getTasks();

        return ResponseEntity.ok(tasks.toString());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTaskById(@PathVariable("id") int id) {
        var task = taskService.getTaskById(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task.toString());
    }

    @PostMapping("")
    public ResponseEntity<String> addTask(@RequestBody CreateTaskDTO newTask) throws ParseException {

        var task = taskService.addTask(newTask.getTitle(), newTask.getDescription(), newTask.getDeadline());
        return ResponseEntity.ok(task.toString());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateTask(@PathVariable("id") int id, @RequestBody UpdateTaskDTO updateTask) throws Exception {
        var task = taskService.updateTask(id, updateTask.getDescription(), updateTask.getDeadline(), updateTask.getCompleted());
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task.toString());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorRespomseDTO> handleParseException(Exception e) {
        e.printStackTrace();
        if(e instanceof ParseException) {
            return ResponseEntity.badRequest().body(new ErrorRespomseDTO("Invalid Date Format - " +e.getMessage()));
        }
        return ResponseEntity.internalServerError().body(new ErrorRespomseDTO("Internal Server Error"));
    }

}
