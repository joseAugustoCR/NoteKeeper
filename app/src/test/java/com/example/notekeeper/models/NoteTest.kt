package com.example.notekeeper.models

import com.example.notekeeper.Note
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test


class NoteTest {

    val TIMESTAMP1 = "02-2020"
    val TIMESTAMP2 = "01-2020"

    // Compare notes equal
    @Test
    internal fun isNotesEqual_identicalProperties() {
        val note1 = Note(
            id = 1,
            title = "Note 1",
            content = "This is note 1",
            timestamp = TIMESTAMP1
        )
        val note2 = Note(
            id = 1,
            title = "Note 1",
            content = "This is note 1",
            timestamp = TIMESTAMP1
        )

        assertEquals(note1, note2)
    }


    // Compare different ids
    @Test
    internal fun isNotesEquals_differentIds() {
        val note1 = Note(
            id = 1,
            title = "Note 1",
            content = "This is note 1",
            timestamp = TIMESTAMP1
        )
        val note2 = Note(
            id = 2,
            title = "Note 1",
            content = "This is note 1",
            timestamp = TIMESTAMP1
        )

        assertNotEquals(note1, note2)
    }

    // Compare different timestamps
    @Test
    internal fun isNotesEquals_differentTimestamps() {
        val note1 = Note(
            id = 1,
            title = "Note 1",
            content = "This is note 1",
            timestamp = TIMESTAMP1
        )
        val note2 = Note(
            id = 1,
            title = "Note 1",
            content = "This is note 1",
            timestamp = TIMESTAMP2
        )

        assertEquals(note1, note2)
    }

    // Compare different titles
    @Test
    internal fun isNotesEquals_differentTitles() {
        val note1 = Note(
            id = 1,
            title = "Note 1",
            content = "This is note 1",
            timestamp = TIMESTAMP1
        )
        val note2 = Note(
            id = 1,
            title = "Note 2",
            content = "This is note 1",
            timestamp = TIMESTAMP1
        )

        assertNotEquals(note1, note2)
    }
}