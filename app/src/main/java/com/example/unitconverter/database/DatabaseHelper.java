package com.example.unitconverter.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.unitconverter.models.HistoryItem;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "unit_converter.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_HISTORY = "history";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_FROM_UNIT = "from_unit";
    public static final String COLUMN_TO_UNIT = "to_unit";
    public static final String COLUMN_INPUT_VALUE = "input_value";
    public static final String COLUMN_OUTPUT_VALUE = "output_value";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    public static final String TABLE_FAVORITES = "favorites";
    public static final String COLUMN_CAT_NAME = "cat_name";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_HISTORY_TABLE = "CREATE TABLE " + TABLE_HISTORY + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_CATEGORY + " TEXT,"
                + COLUMN_FROM_UNIT + " TEXT,"
                + COLUMN_TO_UNIT + " TEXT,"
                + COLUMN_INPUT_VALUE + " TEXT,"
                + COLUMN_OUTPUT_VALUE + " TEXT,"
                + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP" + ")";
        db.execSQL(CREATE_HISTORY_TABLE);

        String CREATE_FAVORITES_TABLE = "CREATE TABLE " + TABLE_FAVORITES + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_CAT_NAME + " TEXT UNIQUE" + ")";
        db.execSQL(CREATE_FAVORITES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVORITES);
        onCreate(db);
    }

    public void addHistory(String category, String from, String to, String input, String output) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CATEGORY, category);
        values.put(COLUMN_FROM_UNIT, from);
        values.put(COLUMN_TO_UNIT, to);
        values.put(COLUMN_INPUT_VALUE, input);
        values.put(COLUMN_OUTPUT_VALUE, output);
        db.insert(TABLE_HISTORY, null, values);
        db.close();
    }

    public List<HistoryItem> getAllHistory() {
        List<HistoryItem> historyList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_HISTORY + " ORDER BY " + COLUMN_TIMESTAMP + " DESC";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                HistoryItem item = new HistoryItem();
                item.setId(cursor.getInt(0));
                item.setCategory(cursor.getString(1));
                item.setFromUnit(cursor.getString(2));
                item.setToUnit(cursor.getString(3));
                item.setInputValue(cursor.getString(4));
                item.setOutputValue(cursor.getString(5));
                item.setTimestamp(cursor.getString(6));
                historyList.add(item);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return historyList;
    }

    public void clearHistory() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_HISTORY, null, null);
        db.close();
    }
}