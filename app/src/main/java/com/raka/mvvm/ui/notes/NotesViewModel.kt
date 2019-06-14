package com.raka.mvvm.ui.notes

import androidx.lifecycle.ViewModel
import com.raka.mvvm.data.Note
import com.raka.mvvm.data.NoteRepository

class NotesViewModel constructor(private val notesRepository: NoteRepository): ViewModel() {

    fun getNotes() = notesRepository.getNotes()

    fun addNotes(note: Note) = notesRepository.addNote(note)
}