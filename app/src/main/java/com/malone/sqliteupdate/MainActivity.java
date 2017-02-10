package com.malone.sqliteupdate;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper ;
    SQLiteDatabase database;
    EditText etVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this,"test.db",null,1);
        database = dbHelper.getWritableDatabase();
        etVersion = (EditText) findViewById(R.id.etVersion);
    }

    public void init(View view) {
        ContentValues values = new ContentValues();
        values.put("name","冲田杏梨");
        values.put("age","32");
        database.insert("person",null,values);
    }

    public void dbUpdate(View view) {
        dbHelper = new DBHelper(this,"test.db",null,Integer.parseInt(etVersion.getText().toString()));
        database = dbHelper.getWritableDatabase();
    }
}
