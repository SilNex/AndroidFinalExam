package com.example.finalexam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseManager extends SQLiteOpenHelper {
    String databaseName;
    String tableName;

    DataBaseManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        databaseName = name;
        tableName = "checkData";
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        Log.d("Created Table : ", "Ok");
        String sql = "CREATE TABLE IF NOT EXISTS "+ tableName + "(data TEXT, updatetime TIMESTAMP);";
        database.execSQL(sql);
        sql = "INSERT INTO "+tableName+"(data, updatetime) values(\"Dump\", DATETIME((STRFTIME('%s', 'now') - 100000), 'unixepoch'));";
        database.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1) {
        String sql = "DROP TABLE "+tableName;
        database.execSQL(sql);
        this.onCreate(database);
    }
}
