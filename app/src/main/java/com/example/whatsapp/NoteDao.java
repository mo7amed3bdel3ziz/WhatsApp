package com.example.whatsapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert
    Void insert(Note note);

    @Update
    Void update(Note note);

    @Delete
    Void delete(Note note);

    @Query("Delete FROM note_table")
    void deleteAllNotes();

    @Query("Select * from note_table ORDER BY msgDate DESC")
    LiveData<List<Note>> getAllNotes();

}
