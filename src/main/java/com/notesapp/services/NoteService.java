package com.notesapp.services;

import com.notesapp.models.NoteModel;
import com.notesapp.repositories.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public boolean saveNote(NoteModel note) {
        try {
            noteRepository.save(note);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public List<NoteModel> getAllNotes() {
        try {
            return noteRepository.findAll();
        }catch (Exception e) {
            return null;
        }
    }

    public Optional<NoteModel> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public boolean updateNote(Long id, NoteModel note) {
        Optional<NoteModel> optionalNote = noteRepository.findById(id);

        if(optionalNote.isEmpty()) return false;

        NoteModel updatedTask = optionalNote.get();
        updatedTask.setTitle(note.getTitle());
        updatedTask.setDescription(note.getDescription());

        noteRepository.save(updatedTask);
        return true;
    }

    public boolean deleteNotes(Long id) {
        Optional<NoteModel> optionalTask = noteRepository.findById(id);

        if(optionalTask.isEmpty()) return false;

        noteRepository.deleteById(id);
        return true;
    }
}
