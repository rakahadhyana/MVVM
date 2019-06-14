package com.raka.mvvm.ui.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.raka.mvvm.R
import com.raka.mvvm.adapter.NotesAdapter
import com.raka.mvvm.data.Note
import com.raka.mvvm.databinding.ActivityNotesBinding
import com.raka.mvvm.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_notes.*

class NotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        initializeUI()
    }

    private fun initializeUI(){
        val factory = InjectorUtils.provideNotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(NotesViewModel::class.java)
        val binding: ActivityNotesBinding = DataBindingUtil.setContentView(this, R.layout.activity_notes)
        val adapter = NotesAdapter()

        binding.notesViewModel = viewModel

        binding.buttonAddNote.setOnClickListener {
            val note = Note(binding.editTextNote.text.toString())
            viewModel.addNotes(note)
            editText_note.setText("")
        }

        binding.recyclerView.adapter = adapter

        viewModel.getNotes().observe(this, Observer { notes ->
            adapter.data = notes
        })

    }
}
