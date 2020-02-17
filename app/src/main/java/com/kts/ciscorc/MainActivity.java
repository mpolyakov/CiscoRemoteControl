package com.kts.ciscorc;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kts.ciscorc.dbase.Note;
import com.kts.ciscorc.dbase.NoteAdapter;
import com.kts.ciscorc.dbase.NoteDataReader;
import com.kts.ciscorc.dbase.NoteDataSource;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private NoteDataSource notesDataSource;
    private NoteDataReader noteDataReader;
    private NoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        initDataSource();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new NoteAdapter(noteDataReader, this);
        adapter.setOnMenuItemClickListener(new NoteAdapter.OnMenuItemClickListener() {


            @Override
            public void onItemDeleteClick(Note note) {
                deleteElement(note);

            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        dataUpdated();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.appbar_gradient));
        }
    }

    private void initDataSource() {
        notesDataSource = new NoteDataSource(getApplicationContext());
        notesDataSource.open();
        noteDataReader = notesDataSource.getNoteDataReader();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_clear:
                clearList();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void clearList() {
        notesDataSource.deleteAll();
        dataUpdated();
    }

    private void deleteElement(Note note) {
        notesDataSource.deleteNote(note);
        dataUpdated();
    }

    private void dataUpdated() {
        noteDataReader.Refresh();
        adapter.notifyDataSetChanged();
    }

}
