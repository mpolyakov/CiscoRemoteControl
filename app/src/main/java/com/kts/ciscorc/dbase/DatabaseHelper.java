package com.kts.ciscorc.dbase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "notes.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NOTES = "notes";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOTE = "note";
    public static final String COLUMN_NOTE_TITLE = "title";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_PLATFORM = "platform";


    public DatabaseHelper(Context context){
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("CREATE TABLE " + TABLE_NOTES + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NOTE + " TEXT," + COLUMN_NOTE_TITLE + " TEXT);");

        db.execSQL("CREATE TABLE " +
                TABLE_NOTES + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NOTE + " TEXT" + " UNIQUE,"
                + COLUMN_NOTE_TITLE + " TEXT,"
                + COLUMN_USERNAME + " TEXT,"
                + COLUMN_PASSWORD + " TEXT,"
                + COLUMN_PLATFORM + " TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        if ((oldVersion == 1) && (newVersion == 2)){
//            String upgradeQuery = "ALTER TABLE " + TABLE_NOTES + " ADD COLUMN " + COLUMN_NOTE_TITLE + " TEXT DEFAULT Title";
//            db.execSQL(upgradeQuery);
//        }
    }
}