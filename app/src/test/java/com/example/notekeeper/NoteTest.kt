package com.example.notekeeper

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class NoteTest {

    val TIMESTAMP1 = "02-2020"
    val TIMESTAMP2 = "01-2020"

    // Compare notes equal
    @Test
    internal fun isNotesEqual_identicalProperties() {
        val note1 = Note(id = 1, title = "Note 1", content = "This is note 1", timestamp = TIMESTAMP1)
        val note2 = Note(id = 1, title = "Note 1", content = "This is note 1", timestamp = TIMESTAMP1)

        assertEquals(note1, note2)
    }
}