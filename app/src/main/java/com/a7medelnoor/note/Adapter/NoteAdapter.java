package com.a7medelnoor.note.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.a7medelnoor.note.MainActivity;
import com.a7medelnoor.note.Model.Notes;
import com.a7medelnoor.note.R;

import java.util.List;
import java.util.Objects;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    MainActivity mainActivity;
    List<Notes> notes;
    private static final String TAG = "NoteAdapter";

    public NoteAdapter(MainActivity mainActivity, List<Notes> notes) {
        this.mainActivity = mainActivity;
        this.notes = notes;
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NoteViewHolder(LayoutInflater.from(mainActivity).inflate(R.layout.item_note, parent, false));
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        Notes noteNotes = notes.get(position);
        Log.d(TAG, "onBindViewHolder: " + noteNotes.toString());
        if (Objects.equals(noteNotes.notePriority, "1")) {
            holder.notePriorityView.setBackgroundResource(R.drawable.green_shape);
        } else if (Objects.equals(noteNotes.notePriority, "2")) {
            holder.notePriorityView.setBackgroundResource(R.drawable.yellow_shape);
        } else if ((Objects.equals(noteNotes.notePriority, "3"))) {
            holder.notePriorityView.setBackgroundResource(R.drawable.red_shape);
        }
        holder.noteTitle.setText(noteNotes.noteTitle);
        holder.noteSubTitle.setText(noteNotes.noteSubTitle);
        holder.noteDate.setText(noteNotes.noteDate);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    static class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView noteTitle, noteSubTitle, noteDate;
        View notePriorityView;

        public NoteViewHolder(View itemView) {
            super(itemView);
            noteTitle = itemView.findViewById(R.id.noteTitleTextView);
            noteSubTitle = itemView.findViewById(R.id.noteSubTitleTextView);
            noteDate = itemView.findViewById(R.id.noteDateTextView);
            notePriorityView = itemView.findViewById(R.id.notePriority);
        }
    }
}
