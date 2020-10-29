package com.example.app3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {
    public static final int VERSION = 2;
    public static final String DB_NAME = "chat.db";
    public static final String TABLE_NAME;
    static {
        TABLE_NAME = "chat";
    }
    
  

    //collumn name table
    public static final String USERID = "user_id";
    public static final String PHONENUMBER = "phoneNo";
    public static final String MESSAGE = "msg";
   

    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME , null ,  VERSION );
    }

    //create table
    @Override
    public void onCreate(SQLiteDatabase db) {
          
        String TABLE_CREATE_QUERY= "CREATE TABLE " + TABLE_NAME + "(" + USERID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PHONENUMBER +  " TEXT, " + MESSAGE + " TEXT)";
          //run table create query
      db.execSQL(TABLE_CREATE_QUERY);

       
    }



    //version update
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
           String DROP_TABLE_QUERY="DROP TABLE IF EXISTS "+TABLE_NAME;
           //drop older table if executed
           db.execSQL(DROP_TABLE_QUERY);
           //create table again
           onCreate(db);

     
    }
}

