package com.a7medelnoor.note.Activity;

import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.a7medelnoor.note.Model.Notes;
import com.a7medelnoor.note.R;
import com.a7medelnoor.note.ViewModel.NoteViewModel;
import com.a7medelnoor.note.databinding.ActivityInsertNoteBinding;

import java.util.Date;

public class InsertNoteActivity extends AppCompatActivity {
    ActivityInsertNoteBinding binding;
    String title, subtitle, notes;
    NoteViewModel viewModel;
    String priority = "1";

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        binding.greenPriority.setOnClickListener(view -> {
            binding.greenPriority.setImageResource(R.drawable.ic_baseline_done_24);
            binding.yellowPriority.setImageResource(0);
            binding.redPriority.setImageResource(0);
            priority = "1";
        });
        binding.yellowPriority.setOnClickListener(view -> {
            binding.greenPriority.setImageResource(0);
            binding.yellowPriority.setImageResource(R.drawable.ic_baseline_done_24);
            binding.redPriority.setImageResource(0);
            priority = "2";
        });
        binding.redPriority.setOnClickListener(view -> {
            binding.greenPriority.setImageResource(0);
            binding.yellowPriority.setImageResource(0);
            binding.redPriority.setImageResource(R.drawable.ic_baseline_done_24);

            priority = "3";

        });
        binding = ActivityInsertNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.doneNoteBtn.setOnClickListener(v -> {
            title = binding.noteTitle.getText().toString();
            subtitle = binding.noteSubTitle.getText().toString();
            notes = binding.note.getText().toString();
            CreateNotes(title, subtitle, notes);
        });
    }

    private void CreateNotes(String title, String subtitle, String notes) {
        Date date = new Date();
        CharSequence sequence = DateFormat.format("MMMMM d,YYYY", date.getTime());
        Notes notes1 = new Notes();
        notes1.noteTitle = title;
        notes1.noteSubTitle = subtitle;
        notes1.notes = notes;
        notes1.noteDate = sequence.toString();
        viewModel.insertNote(notes1);
        Toast.makeText(this, "Note created Successfully", Toast.LENGTH_SHORT).show();
        finish();
    }


}