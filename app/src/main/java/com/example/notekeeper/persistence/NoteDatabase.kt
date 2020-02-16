package com.example.notekeeper.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notekeeper.Note

@Database(
    entities = arrayOf(Note::class),
    version = 1
)
abstract class NoteDatabase : RoomDatabase(){

    abstract fun noteDao() : NoteDao

    companion object {
        val DATABASE_NAME = "notes_db"
//        private var INSTANCE : NoteDatabase? = null
//
//        @Synchronized
//        fun getInstance(context : Context) : NoteDatabase {
//
//            if(INSTANCE == null) {
//                INSTANCE = Room.databaseBuilder(
//                    context.applicationContext,
//                    NoteDatabase::class.java,
//                    "database.db").build()
//            }
//            return INSTANCE as NoteDatabase
//        }
    }
}