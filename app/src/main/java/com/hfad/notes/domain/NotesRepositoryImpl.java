package com.hfad.notes.domain;

import java.util.ArrayList;
import java.util.List;

public class NotesRepositoryImpl implements NotesRepository {

    private final ArrayList<Note> notes = new ArrayList<>();

    public NotesRepositoryImpl() {
        notes.add(new Note(0, "01.09.2021", "Заметка 1", "Hello Fragment 1"));
        notes.add(new Note(1, "02.09.2021", "Заметка 2", "Hello Fragment 2"));
        notes.add(new Note(2, "03.09.2021", "Заметка 3", "Hello Fragment 3"));
        notes.add(new Note(3, "04.09.2021", "Заметка 4", "Hello Fragment 4"));
        notes.add(new Note(4, "05.09.2021", "Заметка 5", "Hello Fragment 5"));
        notes.add(new Note(5, "06.09.2021", "Заметка 6", "Hello Fragment 6"));
        notes.add(new Note(6, "07.09.2021", "Заметка 7", "Hello Fragment 7"));
        notes.add(new Note(7, "01.08.2021", "Заметка 8", "Hello Fragment 8"));
        notes.add(new Note(8, "07.08.2021", "Заметка 9", "Hello Fragment 9"));
        notes.add(new Note(9, "17.08.2021", "Заметка 10", "Hello Fragment 10"));
        notes.add(new Note(10, "08.09.2021", "Заметка 11", "Hello Fragment 11"));
        notes.add(new Note(11, "09.09.2021", "Заметка 12", "Hello Fragment 12"));
        notes.add(new Note(12, "10.09.2021", "Заметка 13", "Hello Fragment 13"));
        notes.add(new Note(13, "11.09.2021", "Заметка 14", "Hello Fragment 14"));
    }

    @Override
    public List<Note> getNotes() {
        return notes;
    }
}
