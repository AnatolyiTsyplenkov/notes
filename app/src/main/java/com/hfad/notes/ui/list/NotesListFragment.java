package com.hfad.notes.ui.list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hfad.notes.R;
import com.hfad.notes.domain.Note;
import com.hfad.notes.domain.NotesRepositoryImpl;

import java.util.List;

public class NotesListFragment extends Fragment implements NotesListView {

    public static final String KEY_SELECTED_NOTE = "KEY_SELECTED_NOTE";
    public static final String KEY_NOTE = "KEY_NOTE";

    private NotesListPresenter presenter;
    private LinearLayout container;
    private OnNoteClicked onNoteClicked;

    public interface OnNoteClicked {
        void onNoteOnClicked(Note note);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnNoteClicked) {
            onNoteClicked = (OnNoteClicked) context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new NotesListPresenter(this, new NotesRepositoryImpl());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        container = view.findViewById(R.id.root);
        presenter.requestNotes();
    }

    @Override
    public void showNotesList(List<Note> notes) {

        for (Note note : notes) {

            View noteItem = LayoutInflater.from(requireContext()).inflate(R.layout.item_note, container, false);

            noteItem.setOnClickListener(view -> {

                if (onNoteClicked != null) {
                    onNoteClicked.onNoteOnClicked(note);
                }

                Bundle bundle = new Bundle();
                bundle.putParcelable(KEY_NOTE, note);

                getParentFragmentManager().setFragmentResult(KEY_SELECTED_NOTE, bundle);
            });

            TextView titleView = noteItem.findViewById(R.id.title);
            String title = note.getTitle();
            titleView.setText(title);

            TextView dateView = noteItem.findViewById(R.id.date);
            String date = note.getDate();
            dateView.setText(date);

            container.addView(noteItem);
        }
    }
}
