package com.raka.mvvm.ui.notes

import dagger.Component

//@Component
interface NotesViewModelComponent {

    fun getNotesViewModel(): NotesViewModelFactory
}