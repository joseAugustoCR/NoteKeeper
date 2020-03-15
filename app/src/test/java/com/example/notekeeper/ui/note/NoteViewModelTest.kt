package com.example.notekeeper.ui.note

import com.example.notekeeper.data.repository.NoteRepository
import com.nhaarman.mockitokotlin2.mock
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class NoteViewModelTest {
    lateinit var noteViewModel: NoteViewModel
    lateinit var noteRepository: NoteRepository

    @BeforeEach
    fun init(){
        noteRepository = mock()
        noteViewModel = NoteViewModel(noteRepository)
    }


    // can't observe a note that hasn't been set
    @Test
    internal fun observeEmptyNote_noteSet(){

    }

    // Observe a note has been set and onChange will trigger in activity
    @Test
    internal fun observeNote_whenSet() {


    }


    // Insert a new note and observe row returned
    @Test
    internal fun insertNote_returnRow() {


    }


    // insert: don't return a new row without observer
    @Test
    internal fun dontReturnInsertRowWithoutObserver() {

    }
}