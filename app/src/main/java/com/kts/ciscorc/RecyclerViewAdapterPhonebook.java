package com.kts.ciscorc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapterPhonebook extends RecyclerView.Adapter<RecyclerViewAdapterPhonebook.ViewHolder> {

    private ArrayList<String> mPhonebookNames = new ArrayList<>();
    private ArrayList<String> mPhonebookNumbers = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapterPhonebook(Context mContext, ArrayList<String> mPhonebookNames, ArrayList<String> mPhonebookNumbers) {
        this.mPhonebookNames = mPhonebookNames;
        this.mPhonebookNumbers = mPhonebookNumbers;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutphonebook_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.phonebName.setText(mPhonebookNames.get(position));
        holder.phonebNumber.setText(mPhonebookNumbers.get(position));
        holder.parentPhonebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, mPhonebookNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mPhonebookNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView phonebName;
        TextView phonebNumber;
        RelativeLayout parentPhonebook;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            phonebName = itemView.findViewById(R.id.textViewNameOfParticipant);
            phonebNumber = itemView.findViewById(R.id.textViewNumberOfParticipant);
            parentPhonebook = itemView.findViewById(R.id.parent_phonebook);
        }
    }
}
