package com.kts.ciscorc.dbase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Closeable;

public class NoteDataReader implements Closeable {
    private Cursor cursor;
    private SQLiteDatabase database;
    private String[] notesAllColumn = {
            DatabaseHelper.COLUMN_ID,
            DatabaseHelper.COLUMN_NOTE,
            DatabaseHelper.COLUMN_NOTE_TITLE
    };

    public NoteDataReader(SQLiteDatabase database){
        this.database = database;
    }

    public void open(){
        query();
        cursor.moveToFirst();
    }

    public void close(){
        cursor.close();
    }

    public void Refresh(){
        int position = cursor.getPosition();
        query();
        cursor.moveToPosition(position);
    }

    private void query(){
        cursor = database.query(DatabaseHelper.TABLE_NOTES, notesAllColumn, null, null, null, null, null);
    }

    public Note getPosition(int position){
        cursor.moveToPosition(position);
        return cursorToNote();
    }

    public int getCount(){
        return cursor.getCount();
    }

    private Note cursorToNote(){
        Note note = new Note();
        note.setId(cursor.getLong(0));
        note.setIpAddr(cursor.getString(1));
        note.setTitle(cursor.getString(2));
        return note;
    }
}
