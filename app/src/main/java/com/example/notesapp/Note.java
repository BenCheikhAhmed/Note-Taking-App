package com.example.notesapp;

public class Note {
    private String content;
    private boolean isSelected;

    public Note(String content) {
        this.content = content;
        this.isSelected = false;
    }

    public String getContent() {
        return content;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
