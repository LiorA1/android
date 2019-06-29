package com.example.databasedemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try
        {
            // Create the database :
            SQLiteDatabase myDB = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);

            // Create the table :
            myDB.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR, age INT(3))");

            // Adding to the table.
            myDB.execSQL("INSERT INTO users(name, age) VALUES ('Nick', 28)");

            ContentValues first = new ContentValues();
            first.put("name", "Nickb");
            first.put("age", 30);
            myDB.insert("users", "(name, age)", first);

            // Setting a cursor :
            Cursor cursor = myDB.rawQuery("SELECT * FROM users", null);
            int nameIndex = cursor.getColumnIndex("name");
            int ageIndex = cursor.getColumnIndex("age");

            // Loop on the Query outcome :
            if(cursor.moveToFirst())
            {
                do
                {
                    Log.i("printed : ", "name: " + cursor.getString(nameIndex)
                            + ". age: " + cursor.getString(ageIndex));

                }while(cursor.moveToNext());
            }


            // Print the path :
            Log.i("***printed:", myDB.toString());

        }
        catch (Exception e)
        {
            Log.e(" My Error: ", e.getMessage());
        }


    }
}
