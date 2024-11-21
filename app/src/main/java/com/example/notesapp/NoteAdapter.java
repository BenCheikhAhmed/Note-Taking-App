package com.example.notesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import java.util.ArrayList;

public class NoteAdapter extends ArrayAdapter<Note> {

    public NoteAdapter(Context context, ArrayList<Note> notes) {
        super(context, 0, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_note, parent, false);
        }

        Note note = getItem(position);

        RadioButton radioButton = convertView.findViewById(R.id.radioButtonSelect);
        TextView textNote = convertView.findViewById(R.id.textNote);

        textNote.setText(note.getContent());
        radioButton.setChecked(note.isSelected());

        // Handle selection state
        radioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            note.setSelected(isChecked);
        });

        return convertView;
    }
}
