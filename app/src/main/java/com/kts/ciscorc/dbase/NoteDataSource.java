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

    public Note addNote(String title, String ipaddr, String username, String password, String platform){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NOTE, ipaddr);
        values.put(DatabaseHelper.COLUMN_NOTE_TITLE, title);
        values.put(DatabaseHelper.COLUMN_USERNAME, username);
        values.put(DatabaseHelper.COLUMN_PASSWORD, password);
        values.put(DatabaseHelper.COLUMN_PLATFORM, platform);

        long insertId = database.insert(DatabaseHelper.TABLE_NOTES, null, values);
        Note newNote = new Note();
        newNote.setIpAddr(ipaddr);
        newNote.setTitle(title);
        newNote.setId(insertId);
        newNote.setUsername(username);
        newNote.setPassword(password);
        newNote.setPlatform(platform);
        return newNote;
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