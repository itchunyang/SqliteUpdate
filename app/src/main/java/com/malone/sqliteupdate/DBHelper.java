package com.malone.sqliteupdate;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by luchunyang on 2017/2/10.
 */

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, VersionFactoryFinal.currentDbVersion());
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE person (_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, age SMALLINT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        update(db,oldVersion,newVersion);
    }

    public void update(SQLiteDatabase db, int oldVersion, int newVersion){
        if(oldVersion < newVersion){
            oldVersion++;
//            Update update = VersionFactory.getUpdate(oldVersion);
            Update update = VersionFactoryFinal.getUpdate(oldVersion);
            if(update == null) {
                Log.i("DBHelper", "update: update == null");
                return;
            }

            update.update(db);
            update(db,oldVersion,newVersion);//递归
        }
    }

}
