package com.example.notekeeper.repository

import com.example.notekeeper.ErrorResponse
import com.example.notekeeper.Note
import com.example.notekeeper.data.Resource
import com.example.notekeeper.data.persistence.NoteDao
import com.example.notekeeper.data.repository.NoteRepository
import com.example.notekeeper.data.repository.NoteRepository.Companion.INSERT_SUCCESS
import com.example.notekeeper.utils.TestUtil
import com.example.notekeeper.utils.TestUtil.Companion.TEST_NOTE_1
import com.nhaarman.mockitokotlin2.*
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Single
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class NoteRepositoryTest {

    val NOTE1 = Note(TEST_NOTE_1)
    lateinit var noteRepository:NoteRepository
    private lateinit var noteDao:NoteDao

    @BeforeEach
    fun initEach(){
        noteDao = mock()
        noteRepository = NoteRepository(noteDao)
    }


    /*
    insert note
    verify method caleld
    confirm observer is triggered
    confirn new rows inserted
     */
    @Test
    internal fun insertNote_returnRow() {
        // arrange
        val insertedRow = 1.toLong()
        val returnedData = Single.just(insertedRow)
        whenever(noteDao.insertNote(any()))
            .doAnswer {
                returnedData
            }

        // act
        val returnedValue = noteRepository.insertNote(NOTE1).blockingFirst()

        // assert
        verify(noteDao).insertNote(any())
        verifyNoMoreInteractions(noteDao)
        System.out.println("returned value = ${returnedValue.data}" )
        assertEquals(Resource.success(1), returnedValue)

    }

    /*
    insert note failure
     */
    @Test
    internal fun insertNote_returnFailure() {
        val insertedRow = -1.toLong()
        val returnedData = Single.just(insertedRow)
        whenever(noteDao.insertNote(any()))
            .doAnswer {
                returnedData
            }

        val returnedValue = noteRepository.insertNote(NOTE1).blockingFirst()

        verify(noteDao).insertNote(any())
        verifyNoMoreInteractions(noteDao)
        assertEquals(Resource.error(), returnedValue)

    }


/*
    insert note null title
     */




}