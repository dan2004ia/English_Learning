package com.example.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.models.Word;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "EnglishLearning.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_WORDS = "words";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

         String CREATE_TABLE = "CREATE TABLE " + TABLE_WORDS + "(id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "english TEXT, arabic TEXT, image_res_id INTEGER)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int old, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORDS);
        onCreate(db);
    }

     public void addWord(Word word) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put("English", word.getEnglish());
        v.put("Arabic", word.getArabic());
        v.put("image_res_id", word.getImageResId());
        db.insert(TABLE_WORDS, null, v);
        db.close();
    }

     public List<Word> getAllWords() {
        List<Word> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_WORDS, null);
        if (c.moveToFirst()) {
            do {
                list.add(new Word(c.getString(1), c.getString(2), c.getInt(3)));
            } while (c.moveToNext());
        }
        c.close();
        return list;
    }
}
