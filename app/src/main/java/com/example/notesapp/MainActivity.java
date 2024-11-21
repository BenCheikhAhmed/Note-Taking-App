package com.example.notesapp;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNote;
    private ArrayList<Note> notesList;
    private NoteAdapter notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        editTextNote = findViewById(R.id.editTextNote);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonDelete = findViewById(R.id.buttonDelete);
        ListView listViewNotes = findViewById(R.id.listViewNotes);

        // Initialize data structures
        notesList = new ArrayList<>();
        notesAdapter = new NoteAdapter(this, notesList);
        listViewNotes.setAdapter(notesAdapter);

        // Set button listeners
        buttonAdd.setOnClickListener(v -> addNote());
        buttonDelete.setOnClickListener(v -> deleteSelectedNotes());
    }

    private void addNote() {
        String noteContent = editTextNote.getText().toString().trim();

        if (!noteContent.isEmpty()) {
            notesList.add(new Note(noteContent));
            notesAdapter.notifyDataSetChanged();
            editTextNote.setText("");
        } else {
            Toast.makeText(this, "Please enter a note", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteSelectedNotes() {
        for (int i = notesList.size() - 1; i >= 0; i--) {
            if (notesList.get(i).isSelected()) {
                notesList.remove(i);
            }
        }
        notesAdapter.notifyDataSetChanged();
    }
}
