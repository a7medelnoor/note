package com.a7medelnoor.note.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.a7medelnoor.note.Model.Notes;
import com.a7medelnoor.note.Dao.NotesDao;

@Database(entities = {Notes.class}, exportSchema = false,version = 1)
public abstract class NoteDatabase extends RoomDatabase {
    public abstract NotesDao notesDao();

    public static NoteDatabase INSTANCE;

    public static NoteDatabase getDataBaseINSTANCE(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class,
                    "Notes_Database").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
