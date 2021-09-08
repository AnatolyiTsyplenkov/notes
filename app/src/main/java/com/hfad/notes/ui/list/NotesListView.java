package com.hfad.notes.ui.list;

import com.hfad.notes.domain.Note;

import java.util.List;

public interface NotesListView {

   void showNotesList(List<Note> notes);
}
