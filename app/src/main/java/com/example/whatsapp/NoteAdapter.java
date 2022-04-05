package com.example.whatsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    private List<Note> notes = new ArrayList<>();

    @Override
    public NoteHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.NoteHolder holder, int position) {
    Note currentNote =notes.get(position);
    holder.textViewName.setText(currentNote.getName());
    holder.textViewBody.setText(currentNote.getBody());
    holder.textViewDate.setText(String.valueOf(currentNote.getMsgDate()));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
    public void setNotes(List<Note> notes){
        this.notes=notes;
        notifyDataSetChanged();
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewBody;
        private TextView textViewDate;

        public NoteHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_View_Name);
            textViewBody = itemView.findViewById(R.id.text_View_body);
            textViewDate = itemView.findViewById(R.id.textViewDate);
        }
    }
}
