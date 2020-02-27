package com.example.notekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notekeeper.repository.NoteRepository
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class NotesActivity : DaggerAppCompatActivity() {

    @Inject lateinit var noteRepository:NoteRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
    }
}
