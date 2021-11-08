package com.a7medelnoor.note;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.a7medelnoor.note.Activity.InsertNoteActivity;
import com.a7medelnoor.note.Adapter.NoteAdapter;
import com.a7medelnoor.note.ViewModel.NoteViewModel;
import com.a7medelnoor.note.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    FloatingActionButton newNoteBtn;
    NoteViewModel noteViewModel;
    RecyclerView noteRecyclerView;
    NoteAdapter noteAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        noteRecyclerView = findViewById(R.id.noteRecyclerView);
        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        mainBinding.addNewNoteBtn.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, InsertNoteActivity.class));
        });
        noteViewModel.getAllNotes.observe(this, notes -> {
            noteRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
            noteAdapter = new NoteAdapter(this, notes);
            noteRecyclerView.setAdapter(noteAdapter);
        });
    }
}