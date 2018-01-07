package com.example.sijaw.finalprep;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDb extends SQLiteOpenHelper {
    SQLiteDatabase sqLiteDatabase;
    public MyDb(Context context) {
        super(context, "Mydb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase=sqLiteDatabase;
        sqLiteDatabase.execSQL("create table contacts " +
                "(id integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists contacts");
        onCreate(sqLiteDatabase);
    }

    public boolean insertdata(int data)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("id",data);
        sqLiteDatabase.insert("contacts",null,contentValues);
        return true;
    }
    public int getdata()
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from contacts",null);
        cursor.moveToFirst();
        return cursor.getInt(cursor.getColumnIndex("id"));
     }
}
