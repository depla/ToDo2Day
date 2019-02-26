package edu.miracosta.cs134.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper
{
    public static final String TAG = DBHelper.class.getSimpleName();


    //STEP 1) define all the database info in CONSTANTS
    public static final String DATABASE_NAME = "ToDo2Day";
    public static final String DATABASE_TABLE = "Tasks";
    public static final String FIELD_PRIMARY_KEY = "_id";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_IS_DONE = "is_Done";



    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);



    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //create all of our data base tables
        // 1) Determine whether to read or write the database (CREATE = write)
        //opens a writeable connection to the todo2day database
        db = getWritableDatabase();


        String sql = "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE + "(" +  FIELD_PRIMARY_KEY
                + " INTEGER PRIMARY KEY," + FIELD_DESCRIPTION + " TEXT," + FIELD_IS_DONE +
                " INTEGER" + ")";


        //log the SQL string
        Log.i(TAG, sql);

        //execute the create table statement
        db.execSQL(sql);




        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
