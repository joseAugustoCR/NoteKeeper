package com.example.notekeeper.di

import android.app.Application
import androidx.room.Room
import com.example.notekeeper.persistence.NoteDao
import com.example.notekeeper.persistence.NoteDatabase
import com.example.notekeeper.persistence.NoteDatabase.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
 class AppModule {

    @Module
    companion object{

        @Singleton
        @Provides
        @JvmStatic
        fun provideNoteDatabase(application: Application) : NoteDatabase{
            return Room.databaseBuilder(
                application.applicationContext,
                NoteDatabase::class.java,
                DATABASE_NAME
            ).build()
        }

        @Singleton
        @Provides
        @JvmStatic
        fun provideNoteDao(noteDatabase: NoteDatabase) : NoteDao{
            return noteDatabase.noteDao()
        }

    }
}