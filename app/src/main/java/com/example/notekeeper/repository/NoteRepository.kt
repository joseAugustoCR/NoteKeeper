package com.example.notekeeper.repository

import com.example.notekeeper.persistence.NoteDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteRepository @Inject constructor(val noteDao: NoteDao) {


}