package com.kts.ciscorc.dbase;

import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.kts.ciscorc.R;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private NoteDataReader noteDataReader;
    private OnMenuItemClickListener itemMenuClickListener;

    public NoteAdapter(NoteDataReader noteDataReader){
        this.noteDataReader = noteDataReader;
    }

    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(NoteAdapter.ViewHolder holder, int position) {
        holder.bind(noteDataReader.getPosition(position));
    }

    @Override
    public int getItemCount() {
        return noteDataReader.getCount();
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener){
        this.itemMenuClickListener = onMenuItemClickListener;
    }

    public interface OnMenuItemClickListener{
        void onItemEditClick(Note note);
        void onItemDeleteClick(Note note);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textNote;
        private Note note;

        public ViewHolder(View itemView){
            super(itemView);
            textNote = itemView.findViewById(R.id.textTitle);
            textNote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemMenuClickListener != null){
                        showPopupMenu(textNote);
                    }
                }
            });
        }

        public void bind(Note note){
            this.note = note;
            textNote.setText(note.getTitle());
        }

        private void showPopupMenu(View view){
            PopupMenu popup = new PopupMenu(view.getContext(), view);
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.context_menu, popup.getMenu());
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.menu_edit:
                            itemMenuClickListener.onItemEditClick(note);
                            return true;
                        case R.id.menu_delete:
                            itemMenuClickListener.onItemDeleteClick(note);
                            return true;
                    }
                    return false;
                }
            });
            popup.show();
        }


    }
}
