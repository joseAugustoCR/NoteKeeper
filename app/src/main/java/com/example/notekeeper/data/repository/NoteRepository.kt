package com.example.notekeeper.data.repository

import com.example.notekeeper.Note
import com.example.notekeeper.data.Resource
import com.example.notekeeper.data.persistence.NoteDao
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteRepository @Inject constructor(val noteDao: NoteDao) {

    val timeDelay = 0.toLong()
    val timeUnit = TimeUnit.SECONDS

    companion object{
        val NOTE_TITLE_NULL = "Note title cannot be null"
        val INVALID_NOTE_ID = "Invalid id. Can't delete note"
        val DELETE_SUCCESS = "Delete success"
        val DELETE_FAILURE = "Delete failure"
        val UPDATE_SUCCESS = "Update success"
        val UPDATE_FAILURE = "Update failure"
        val INSERT_SUCCESS = "Insert success"
        val INSERT_FAILURE = "Insert failure"
    }

    fun insertNote(note: Note) : Flowable<Resource<Int>>{

        return  noteDao.insertNote(note)
            .delaySubscription(timeDelay, timeUnit)
            .map {
                if(it > 0) {
                    return@map Resource.success(it.toInt())
                }else{
                    return@map Resource.error<Int>()
                }

            }
            .onErrorReturn {
                Resource.error<Int>()
            }
            .subscribeOn(Schedulers.io())
            .toFlowable()
    }


}