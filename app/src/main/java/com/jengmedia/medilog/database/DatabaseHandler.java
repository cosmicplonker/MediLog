package com.jengmedia.medilog.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jengmedia.medilog.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MediLog";
    private static final String LOG_T_NAME = "LOG", L_ID = "ID", L_NAME="NAME", L_DATE="DATE";

    public DatabaseHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + LOG_T_NAME + " (" + L_ID + " Int, " + L_NAME + " VARCHAR, " + L_DATE + " TEXT)";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + LOG_T_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertTimestamp(String logTimestamp){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        Log log = new Log(1,"Asthma",logTimestamp);

        content.put(L_ID,log.getID());
        content.put(L_NAME,log.getName());
        content.put(L_DATE,log.getDate());

        db.insert(LOG_T_NAME, null, content);
        return true;
    }

    public String getStamps(){
        String query = "SELECT * FROM " + LOG_T_NAME;
        SQLiteDatabase sql = this.getReadableDatabase();
        Cursor c = sql.rawQuery(query, null);

        return "" + c.getCount();
    }
}
