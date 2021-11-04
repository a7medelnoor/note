package com.a7medelnoor.note.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.a7medelnoor.note.Model.Notes;
import com.a7medelnoor.note.Repository.NoteRepository;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    public NoteRepository repository;
    public LiveData<List<Notes>> getAllNotes;

    public NoteViewModel(Application application) {
        super(application);
        repository = new NoteRepository(application);
        getAllNotes = repository.getAllNotes;
    }

    public void insertNote(Notes notes) {
        repository.insertNote(notes);
    }

    public void deleteNote(int id) {
        repository.deleteNote(id);
    }

    public void updateNote(Notes notes) {
        repository.updateNotes(notes);
    }
}
