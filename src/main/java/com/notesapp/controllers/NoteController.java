package com.notesapp.controllers;

import com.notesapp.models.NoteModel;
import com.notesapp.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notesApi")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:5173"})
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @PostMapping("/saveNote")
    public boolean saveTask(@RequestBody NoteModel task) {
        return noteService.saveNote(task);
    }

    @GetMapping("/getAllNotes")
    public List<NoteModel> getAllTasks() {
        return noteService.getAllNotes();
    }

    @GetMapping("/getNoteById")
    public Optional<NoteModel> getTaskById(@RequestParam("id") Long id) {
        return noteService.getNoteById(id);
    }

    @PutMapping("/updateNote")
    public boolean updateTask(@RequestParam("id") Long id, @RequestBody NoteModel note) {
        return noteService.updateNote(id, note);
    }

    @DeleteMapping("/deleteNote")
    public boolean deleteTask(@RequestParam("id") Long id) {
        return noteService.deleteNotes(id);
    }
}
