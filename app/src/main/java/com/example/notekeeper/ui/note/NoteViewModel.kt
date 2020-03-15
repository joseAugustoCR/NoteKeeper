package com.example.notekeeper.ui.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notekeeper.Note
import com.example.notekeeper.data.Resource
import com.example.notekeeper.data.repository.NoteRepository
import java.lang.Exception
import javax.inject.Inject

class NoteViewModel @Inject constructor(val noteRepository: NoteRepository) : ViewModel(){

    val note = MutableLiveData<Note>()

    fun observeNote() : LiveData<Note>{
        return note
    }

    fun setNote(note: Note){
        this.note.value = note
    }

    fun insertNote() : LiveData<Resource<Int>>{
        val mNote = note.value
        mNote ?: throw Exception()

        return LiveDataReactiveStreams.fromPublisher(
            noteRepository.insertNote(mNote)
        )

    }

}