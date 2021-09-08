package com.hfad.notes.ui.list;

import com.hfad.notes.domain.Note;
import com.hfad.notes.domain.NotesRepository;

import java.util.List;

public class NotesListPresenter {

    private final NotesListView view;
    private final NotesRepository repository;

    public NotesListPresenter(NotesListView view, NotesRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void requestNotes() {
        List<Note> notesList = repository.getNotes();
        view.showNotesList(notesList);
    }
}
