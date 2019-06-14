package com.raka.mvvm.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class FakeNoteDao constructor(){
    private val notesList = mutableListOf<Note>()
    private val notes = MutableLiveData<List<Note>>()

    init {
        notes.value = notesList
    }

    fun addNote(note: Note){
        notesList.add(note)
        notes.value = notesList
    }

    fun getNotes() = notes as LiveData<List<Note>>
}