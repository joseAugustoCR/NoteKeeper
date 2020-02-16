package com.example.notekeeper.persistence

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notekeeper.Note
import io.reactivex.Single

@Dao
interface NoteDao {

    @Insert
    fun insertNote(note:Note) : Single<Long>

    @Query("SELECT * FROM notes")
    fun getNotes() : LiveData<List<Note>>

    @Delete
    fun deleteNote(note: Note) : Single<Int>

    @Update
    fun updateNote(note: Note) : Single<Int>

}