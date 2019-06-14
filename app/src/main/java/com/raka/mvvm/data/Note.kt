package com.raka.mvvm.data

data class Note(val noteText: String) {
    override fun toString(): String {
        return noteText
    }
}