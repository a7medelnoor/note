package com.a7medelnoor.note.Dao;

import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.a7medelnoor.note.Model.Notes;

import java.util.List;

@androidx.room.Dao
public interface NotesDao {
    @Query("SELECT * FROM notes_database")
    List<Notes> getAllNotes();

    @Insert
    void insertNotes(Notes... notes);

    @Query("DELETE FROM notes_database WHERE id=id")
    void deleteNotes(int id);

    @Update
    void updateNotes(Notes... notes);
}
