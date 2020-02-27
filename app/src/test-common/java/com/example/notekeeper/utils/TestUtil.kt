package com.example.notekeeper.utils

import com.example.notekeeper.Note
import java.util.*

class TestUtil {

    companion object{

        const val TIMESTAMP_1 = "02-2020"
        val TEST_NOTE_1 = Note(title = "Take out the trash", content = "It's garbage day tomorrow.", timestamp =  TIMESTAMP_1)


        const val TIMESTAMP_2 = "03-2020"
        val TEST_NOTE_2 = Note(title = "Anniversary gift", content = "Buy an anniversary gift.", timestamp =  TIMESTAMP_2)

        val TEST_NOTE_LIST = Collections.unmodifiableList(
            arrayListOf(
                Note(id = 1, title = "Take out the trash", content = "It's garbage day tomorrow.", timestamp = TIMESTAMP_1),
                Note(id = 2, title =  "Anniversary gift", content = "Buy an anniversary gift.", timestamp = TIMESTAMP_1)
            )
        )
    }
}