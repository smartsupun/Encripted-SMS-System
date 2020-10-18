package com.example.app3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {
    private static final int VERSION = 2;
    private static final String DB_NAME = "sms";
    private static final String TABLE_NAME1 = "login";
    private static final String TABLE_NAME2 = "chat";

    //collumn name table1
    private static final String USERID = "user_id";
    private static final String NAME = "Name";
    private static final String PHONENUMBER = "phonenumber";
    private static final String PASSWORD = "password";

    //collumn name table2
    private static final String MESSAGEID = "message_id";
    private static final String SENDERID = "sender_id";
    private static final String RECIEVERID = "reciever_id";
    private static final String MESSAGE = "message";
    private static final String DATE = "date";
    private static final String TIME = "time";

    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME , null ,  VERSION );
    }

    //create table
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
          String TABLE_CREATE_QUERY1= "CREATE TABLE " + TABLE_NAME1 + "" +"("
                  +USERID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                  +NAME + " TEXT,"
                  +PHONENUMBER + " TEXT,"
                  +PASSWORD + " TEXT,"+
                  ");";
          //run table create query
        sqLiteDatabase.execSQL(TABLE_CREATE_QUERY1);

        Object user_id;
        String TABLE_CREATE_QUERY2= String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY AUTOINCREMENT,%s INTEGERREFERENCESTABLE_NAME1(USERID),%s INTEGERREFERENCESTABLE_NAME1(USERID),%s TEXT,%s DATE,%s TIME,);", TABLE_NAME2, MESSAGEID, SENDERID, RECIEVERID, MESSAGE, DATE, TIME);
        //run table create query
        sqLiteDatabase.execSQL(TABLE_CREATE_QUERY2);
    }

    //version update
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
           String DROP_TABLE_QUERY1="DROP TABLE IF EXISTS "+TABLE_NAME1;
           //drop older table if executed
           sqLiteDatabase.execSQL(DROP_TABLE_QUERY1);
           //create table again
           onCreate(sqLiteDatabase);

        String DROP_TABLE_QUERY2="DROP TABLE IF EXISTS "+TABLE_NAME2;
        //drop older table if executed
        sqLiteDatabase.execSQL(DROP_TABLE_QUERY1);
        //create table again
        onCreate(sqLiteDatabase);
    }
}
