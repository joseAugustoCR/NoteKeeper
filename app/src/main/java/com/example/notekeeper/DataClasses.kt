package com.example.notekeeper

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import org.jetbrains.annotations.NotNull

@Parcelize
@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) var id:Int = 0,
    @NonNull var title:String = "",
    var content:String?=null,
    var timestamp:String?=null
) : Parcelable {

    @Ignore
    constructor(note:Note) : this(
        note.id,
        note.title,
        note.content,
        note.timestamp)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Note
        if (id != other.id) return false
        if (title != other.title) return false
        if (content != other.content) return false
        return true
    }

}

data class ErrorResponse(var errorMsg:String?="")
