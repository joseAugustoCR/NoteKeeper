package com.example.notekeeper

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.notekeeper.data.persistence.NoteDao
import com.example.notekeeper.data.persistence.NoteDatabase
import org.junit.After
import org.junit.Before

abstract class NoteDatabaseTest {

    var noteDatabase:NoteDatabase?=null

    fun getNoteDao() : NoteDao?{
        return noteDatabase?.noteDao()
    }

    @Before
    fun init(){
        noteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NoteDatabase::class.java
        ).build()
    }

    @After
    fun finish(){
        noteDatabase?.close()
    }
}