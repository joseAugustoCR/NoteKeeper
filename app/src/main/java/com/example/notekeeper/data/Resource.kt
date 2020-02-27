package com.example.notekeeper.data

import com.example.notekeeper.ErrorResponse
import com.example.notekeeper.Note


class Resource<T>(val status: Status, val data: T?=null, val errors: ErrorResponse?=null, var statusCode:Int? = 0) {

    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(errors: ErrorResponse?=null, statusCode: Int?=0): Resource<T> {
            return Resource(Status.ERROR, null, errors, statusCode =statusCode)
        }

        fun <T> loading(data: T?=null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Resource<*>

        if (status != other.status) return false
        if (data != other.data) return false
        if (errors != other.errors) return false
        if (statusCode != other.statusCode) return false

        return true
    }




}