package com.raka.mvvm.ui.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.raka.mvvm.data.NoteRepository

class NotesViewModelFactory constructor(val noteRepository: NoteRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NotesViewModel(noteRepository) as T
    }
}