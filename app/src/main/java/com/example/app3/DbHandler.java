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
    
    //public static final String TABLE_NAME2 = "";

    //collumn name table1
    public static final String USERID = "user_id";
    //public static final String NAME = "Name";
    public static final String PHONENUMBER = "phoneNo";
    //public static final String PASSWORD = "password";

    //collumn name table2
    //public static final String MESSAGEID = "message_id";
   // public static final String SENDERID = "sender_id";
    //public static final String RECIEVERID = "reciever_id";
    public static final String MESSAGE = "msg";
    //public static final String DATE = "date";
    //public static final String TIME = "time";

    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME , null ,  VERSION );
    }

    //create table
    @Override
    public void onCreate(SQLiteDatabase db) {
          /* +USERID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                 +NAME + " TEXT,"
                  +PHONENUMBER + " TEXT,"
                 +PASSWORD + " TEXT,"+  */
        String TABLE_CREATE_QUERY= String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY AUTOINCREMENT,%s TEXT,%s TEXT, ) ;", TABLE_NAME, USERID, PHONENUMBER, MESSAGE);
          //run table create query
      db.execSQL(TABLE_CREATE_QUERY);

        /*Object user_id;
        String TABLE_CREATE_QUERY2= String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY AUTOINCREMENT,%s INTEGERREFERENCESTABLE_NAME1(USERID),%s INTEGERREFERENCESTABLE_NAME1(USERID),%s TEXT,%s DATE,%s TIME,);", TABLE_NAME2, MESSAGEID, SENDERID, RECIEVERID, MESSAGE, DATE, TIME);
        //run table create query
       db.execSQL(TABLE_CREATE_QUERY2);  */
    }



    //version update
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
           String DROP_TABLE_QUERY="DROP TABLE IF EXISTS "+TABLE_NAME;
           //drop older table if executed
           db.execSQL(DROP_TABLE_QUERY);
           //create table again
           onCreate(db);

       /* String DROP_TABLE_QUERY2="DROP TABLE IF EXISTS "+TABLE_NAME2;
        //drop older table if executed
        db.execSQL(DROP_TABLE_QUERY2);
        //create table again
        onCreate(db);  */
    }
}

