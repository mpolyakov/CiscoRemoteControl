package com.kts.ciscorc.dbase;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.kts.ciscorc.DialActivity;
import com.kts.ciscorc.MainPresenter;
import com.kts.ciscorc.R;
import com.kts.ciscorc.data.ConnectionClass;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private NoteDataReader noteDataReader;
    private OnMenuItemClickListener itemMenuClickListener;
    private Context mContext;
    final MainPresenter presenter = MainPresenter.getInstance();

    public NoteAdapter(NoteDataReader noteDataReader, Context mContext){
        this.noteDataReader = noteDataReader;
        this.mContext = mContext;
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
        void onItemDeleteClick(Note note);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textNote;
        private TextView textIPaddr;
        private RelativeLayout circleParent;
        private Note note;

        public ViewHolder(View itemView){
            super(itemView);
            textNote = itemView.findViewById(R.id.textTitle);
            textIPaddr = itemView.findViewById(R.id.textIPaddr);
            circleParent = itemView.findViewById(R.id.circle_parent);
            circleParent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Handler handler = new Handler();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            final String response = ConnectionClass.connect(note.getIpAddr(), note.getUsername(), note.getPassword(), mContext.getString(R.string.getstatus));
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(mContext, response, Toast.LENGTH_SHORT).show();
                                    if (response.equals("OK")){
                                        presenter.setIpAddress(note.getIpAddr());
                                        presenter.setLogin(note.getUsername());
                                        presenter.setPassword(note.getPassword());
                                        presenter.setCodecPlatform(note.getPlatform());
                                        Intent intent = new Intent(mContext, DialActivity.class);
                                        mContext.startActivity(intent);
                                    }
                                }
                            });
                        }
                    }).start();

                }
            });

            circleParent.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (itemMenuClickListener != null){
                        showPopupMenu(circleParent);
                        return true;
                    }
                    return false;
                }
            });
        }

        public void bind(Note note){
            this.note = note;
            textNote.setText(note.getTitle());
            textIPaddr.setText(note.getIpAddr());
        }

        private void showPopupMenu(View view){
            PopupMenu popup = new PopupMenu(view.getContext(), view);
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.context_menu, popup.getMenu());
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()){
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
