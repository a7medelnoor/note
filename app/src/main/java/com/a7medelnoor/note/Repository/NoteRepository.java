package com.a7medelnoor.note.Repository;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import com.a7medelnoor.note.Dao.NotesDao;
import com.a7medelnoor.note.Database.NoteDatabase;
import com.a7medelnoor.note.Model.Notes;

import java.util.List;

public class NoteRepository {
    public NotesDao notesDao;
    public LiveData<List<Notes>> getAllNotes;

    public NoteRepository(Application application) {
        NoteDatabase database = NoteDatabase.getDataBaseINSTANCE(application);
        notesDao = database.notesDao();
        getAllNotes = notesDao.getAllNotes();
    }
    public void insertNote(Notes notes){
        notesDao.insertNotes(notes);
    }
    public void deleteNote(int id){
        notesDao.deleteNotes(id);
    }
   public void updateNotes(Notes notes){
        notesDao.updateNotes(notes);
    }
}
