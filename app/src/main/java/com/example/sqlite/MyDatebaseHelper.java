package com.example.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatebaseHelper extends SQLiteOpenHelper {
    public static  final  String CEEAT_Student="create table Student(" +
            "id integer primary key autoincrement," +
            "name text," +
            "number text)";

    private  Context mContext;
    public MyDatebaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CEEAT_Student);
        Toast.makeText(mContext,"Creat succeeded",Toast.LENGTH_SHORT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
