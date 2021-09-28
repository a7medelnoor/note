package com.a7medelnoor.note;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Notes_DataBase")
public class Notes {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "note_title")
    String noteTitle;
    @ColumnInfo(name = "note_subtitle")
    String noteSubTitle;
    @ColumnInfo(name = "note_date")
    String noteDate;
    @ColumnInfo(name = "notes")
    String notes;
    @ColumnInfo(name = "note_priority")
    String notePriority;
}
