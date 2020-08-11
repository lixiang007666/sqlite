package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.security.PrivateKey;

import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

public class MainActivity extends AppCompatActivity {
    private MyDatebaseHelper dbHelper;
    private Button creatDatabase;
    private Button adddata;
    private Button querybutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteStudioService.instance().start(this);
        dbHelper=new MyDatebaseHelper(this,"studentstore.db",null,1);
        creatDatabase=findViewById(R.id.creat_database);
        creatDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();
            }
        });




        adddata=findViewById(R.id.add_data);
        adddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("name","zhangsan");
                values.put("number","12321");
                db.insert("Student",null,values);
            }
        });


        querybutton=findViewById(R.id.query_data);
        querybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                Cursor cursor=db.query("Student",null,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do {
                        String name=cursor.getString(cursor.getColumnIndex("name"));
                        String number=cursor.getString(cursor.getColumnIndex("number"));
                        Log.d("Mainactivity","name   "+name);
                        Log.d("Mainactivity","number   "+number);





                }while(cursor.moveToNext());
cursor.close();

            }}
        });
    }
}
