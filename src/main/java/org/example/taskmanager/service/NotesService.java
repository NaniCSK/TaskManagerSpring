package org.example.taskmanager.service;

import org.example.taskmanager.entities.NoteEntity;
import org.example.taskmanager.entities.TaskEntity;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NotesService {

    private TaskService taskService;
    private HashMap<Integer, TaskNoteHolder> taksNoteHandler = new HashMap<>();

    public NotesService(TaskService taskService) {
        this.taskService = taskService;
    }

    class TaskNoteHolder {
        protected int id = 1;
        protected List<NoteEntity> notes= new ArrayList<>();
    }

    public List<NoteEntity> getNotesForTask(int taskId) {
        TaskEntity task = taskService.getTaskById(taskId);
        if(task == null){
            return null;
        }
        if(!taksNoteHandler.containsKey(taskId)){
            taksNoteHandler.put(taskId, new TaskNoteHolder());
        }
        return taksNoteHandler.get(taskId).notes;
    }

    public NoteEntity addNoteForTask(int taskId, String title, String content) {
        TaskEntity task = taskService.getTaskById(taskId);
        if(task == null){
            return null;
        }
        if(!taksNoteHandler.containsKey(taskId)){
            taksNoteHandler.put(taskId, new TaskNoteHolder());
        }
        NoteEntity note = new NoteEntity();
        note.setId(taksNoteHandler.get(taskId).id);
        note.setTitle(title);
        note.setDescription(content);
        taksNoteHandler.get(taskId).notes.add(note);
        taksNoteHandler.get(taskId).id++;
        return note;
    }

}
