package com.a7medelnoor.note;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.a7medelnoor.note.Activity.InsertNoteActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton newNoteBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newNoteBtn = findViewById(R.id.addNewNoteBtn);
        newNoteBtn.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, InsertNoteActivity.class));
        });
    }
}