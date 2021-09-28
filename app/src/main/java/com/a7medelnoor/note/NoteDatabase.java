package com.a7medelnoor.note;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Notes.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {
    public abstract NotesDao notesDao();

    public static NoteDatabase INSTANCE;

    public static NoteDatabase getDataBaseINSTANCE(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class,
                    "Notes_Database").build();
        }
        return INSTANCE;
    }
}
