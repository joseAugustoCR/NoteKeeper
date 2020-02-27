package com.example.notekeeper.ui.noteslist

import android.os.Bundle
import com.example.notekeeper.R
import com.example.notekeeper.data.repository.NoteRepository
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class NotesActivity : DaggerAppCompatActivity() {

    @Inject lateinit var noteRepository:NoteRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
    }
}
