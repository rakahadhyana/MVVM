package com.raka.mvvm.utilities

import com.raka.mvvm.data.FakeDatabase
import com.raka.mvvm.data.NoteRepository
import com.raka.mvvm.ui.notes.NotesViewModelFactory

object InjectorUtils {

    fun provideNotesViewModelFactory(): NotesViewModelFactory{
        val noteRepository = NoteRepository.getInstance(FakeDatabase.getInstance().noteDao)
        return NotesViewModelFactory(noteRepository)
    }
}