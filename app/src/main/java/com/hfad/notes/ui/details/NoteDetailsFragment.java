package com.hfad.notes.ui.details;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hfad.notes.R;
import com.hfad.notes.domain.Note;
import com.hfad.notes.ui.list.NotesListFragment;

public class NoteDetailsFragment extends Fragment {

    private static final String ARG_NOTE = "ARG_NOTE";
    private TextView title;
    private TextView body;


    public NoteDetailsFragment() {
        super(R.layout.fragment_note_detais);
    }

    public static NoteDetailsFragment newInstance(Note note) {
        NoteDetailsFragment fragment = new NoteDetailsFragment();

        Bundle arguments = new Bundle();
        arguments.putParcelable(ARG_NOTE, note);
        fragment.setArguments(arguments);

        return fragment;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        title = view.findViewById(R.id.title);
        body = view.findViewById(R.id.body);

        getParentFragmentManager().setFragmentResultListener(NotesListFragment.KEY_SELECTED_NOTE, getViewLifecycleOwner(), (requestKey, result) -> {
            Note note = result.getParcelable(NotesListFragment.KEY_NOTE);
            displayNote(note);
        });

        if (getArguments() != null && getArguments().containsKey(ARG_NOTE)) {
            Note note = getArguments().getParcelable(ARG_NOTE);

            if (note != null) {
                displayNote(note);
            }


        }
    }

    private void displayNote(Note note) {
        title.setText(note.getTitle());
        body.setText(note.getBody());

    }
}
