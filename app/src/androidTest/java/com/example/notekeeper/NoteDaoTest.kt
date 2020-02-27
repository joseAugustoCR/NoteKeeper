package com.example.notekeeper

import android.database.sqlite.SQLiteConstraintException
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import com.example.notekeeper.utils.LiveDataTestUtil
import com.example.notekeeper.utils.TestUtil
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertFailsWith

class NoteDaoTest : NoteDatabaseTest() {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    // Insert, read, delete
    @Test
    fun insert_read_delete(){
        val note = Note(TestUtil.TEST_NOTE_1)

        // insert
        getNoteDao()?.insertNote(note)?.blockingGet()

        //read
        val liveDataTestUtil  = LiveDataTestUtil<List<Note>>()
        var insertedNotes = liveDataTestUtil.getValue(getNoteDao()?.getNotes())

        assertNotNull(insertedNotes)
        assertNotEquals(insertedNotes.size, 0)
        assertEquals(note.content, insertedNotes.get(0).content)
        assertEquals(note.timestamp, insertedNotes.get(0).timestamp)
        assertEquals(note.title, insertedNotes.get(0).title)

        note.id = insertedNotes.get(0).id
        assertEquals(note, insertedNotes.get(0))

        //delete
        getNoteDao()?.deleteNote(note)?.blockingGet()

        insertedNotes = liveDataTestUtil.getValue(getNoteDao()?.getNotes())
        assertEquals(0, insertedNotes.size)
    }


    //  Insert, read, update, read, delete
    @Test
    fun insert_read_update_read_delete(){
        val note = Note(TestUtil.TEST_NOTE_1)

        getNoteDao()?.insertNote(note)?.blockingGet()

        val liveDataTestUtil = LiveDataTestUtil<List<Note>>()
        var insertedNotes = liveDataTestUtil.getValue(getNoteDao()?.getNotes())
        assertNotNull(insertedNotes)
        assertNotEquals(0, insertedNotes.size)
        note.id = insertedNotes.get(0).id
        assertEquals(note, insertedNotes.get(0))

        note.title = "New title"
        getNoteDao()?.updateNote(note)?.blockingGet()
        insertedNotes = liveDataTestUtil.getValue(getNoteDao()?.getNotes())
        assertEquals(note.title, insertedNotes.get(0).title)

        getNoteDao()?.deleteNote(note)?.blockingGet()
        insertedNotes = liveDataTestUtil.getValue(getNoteDao()?.getNotes())
        assertEquals(0, insertedNotes.size)

    }

}