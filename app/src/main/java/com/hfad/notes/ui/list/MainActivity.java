package com.hfad.notes.ui.list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.hfad.notes.R;
import com.hfad.notes.domain.Note;
import com.hfad.notes.ui.details.NoteDetailsActivity;

public class MainActivity extends AppCompatActivity implements NotesListFragment.OnNoteClicked {

    private Note selectedNote;
    public static final String ARG_NOTE = "ARG_NOTE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onNoteOnClicked(Note note) {

        selectedNote = note;

        Intent intent = new Intent(this, NoteDetailsActivity.class);
        intent.putExtra(NoteDetailsActivity.ARG_NOTE, note);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        if (selectedNote != null) {
            outState.getParcelable(ARG_NOTE);
        }

        super.onSaveInstanceState(outState);
    }
}