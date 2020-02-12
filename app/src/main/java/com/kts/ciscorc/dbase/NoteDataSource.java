package com.kts.ciscorc.dbase;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.io.Closeable;

public class NoteDataSource implements Closeable {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    private NoteDataReader noteDataReader;

    public NoteDataSource(Context context){
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException{
        database = dbHelper.getWritableDatabase();
        noteDataReader = new NoteDataReader(database);
        noteDataReader.open();
    }

    public void close(){
        noteDataReader.close();
        dbHelper.close();
    }

    public Note addNote(String title, String description){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NOTE, description);
        values.put(DatabaseHelper.COLUMN_NOTE_TITLE, title);

        long insertId = database.insert(DatabaseHelper.TABLE_NOTES, null, values);
        Note newNote = new Note();
        newNote.setIpAddr(description);
        newNote.setTitle(title);
        newNote.setId(insertId);
        return newNote;
    }

    public void editNote(Note note, String description, String title){
        ContentValues editNote = new ContentValues();
        editNote.put(dbHelper.COLUMN_ID, note.getId());
        editNote.put(dbHelper.COLUMN_NOTE, description);
        editNote.put(dbHelper.COLUMN_NOTE_TITLE, title);

        database.update(dbHelper.TABLE_NOTES, editNote, dbHelper.COLUMN_ID + "=" + note.getId(), null);
    }

    public void deleteNote(Note note){
        long id = note.getId();
        database.delete(DatabaseHelper.TABLE_NOTES, DatabaseHelper.COLUMN_ID + "=" + id, null);
    }

    public void deleteAll(){
        database.delete(DatabaseHelper.TABLE_NOTES, null, null);
    }

    public NoteDataReader getNoteDataReader() {
        return noteDataReader;
    }
}