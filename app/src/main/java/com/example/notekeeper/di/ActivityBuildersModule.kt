package com.example.daggersample.di

import com.example.notekeeper.ui.noteslist.NotesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector( )
    abstract fun contributeNotesActivity(): NotesActivity


    // Kotlin doesn't have static methods so we need to wrap in a companion object and annotate with @JvmStatic
    @Module
    companion object {

//        @JvmStatic
//        @Provides //declare a string dependency
//        fun doSomething(): String {
//            return "Doing something..."
//        }


    }
}