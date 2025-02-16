package org.example.taskmanager.controller;

import org.example.taskmanager.dto.CreateNoteDTO;
import org.example.taskmanager.dto.CreateNotesResponseDTO;
import org.example.taskmanager.entities.NoteEntity;
import org.example.taskmanager.service.NotesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks/{taskId}/notes")
public class NotesController {

    private final NotesService notesService;
    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("")
    public ResponseEntity<List<NoteEntity>> getNotes(@PathVariable("taskId") int taskId) {
        var note = notesService.getNotesForTask(taskId);
        return ResponseEntity.ok(note);
    }

    @PostMapping("")
    public ResponseEntity<CreateNotesResponseDTO> addNote(@PathVariable("taskId") int taskId, @RequestBody CreateNoteDTO note) {
        var noteEntity = notesService.addNoteForTask(taskId, note.getTitle(), note.getContent());
        return ResponseEntity.ok(new CreateNotesResponseDTO(taskId, noteEntity));
    }
}
