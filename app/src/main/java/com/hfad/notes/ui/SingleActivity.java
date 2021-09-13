package com.hfad.notes.ui;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;
import com.hfad.notes.R;
import com.hfad.notes.domain.Note;
import com.hfad.notes.ui.details.NoteDetailsFragment;
import com.hfad.notes.ui.list.NotesListFragment;
import com.hfad.notes.ui.menu.AboutFragment;
import com.hfad.notes.ui.menu.SettingsFragment;

public class SingleActivity extends AppCompatActivity implements NotesListFragment.OnNoteClicked {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        if (savedInstanceState == null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new NotesListFragment())
                    .commit();
        }

        Toolbar toolbar = findViewById(R.id.toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.open_drawer,
                R.string.close_drawer
        );

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(item -> {

            if (item.getItemId() == R.id.settings) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new SettingsFragment())
                        .addToBackStack("Settings menu")
                        .commit();

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }

            if (item.getItemId() == R.id.about) {

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new AboutFragment())
                        .addToBackStack("About menu")
                        .commit();

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
            return false;
        });
    }

    @Override
    public void onNoteOnClicked(Note note) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new NoteDetailsFragment())
                .addToBackStack("Details Fragment")
                .commit();
    }
}