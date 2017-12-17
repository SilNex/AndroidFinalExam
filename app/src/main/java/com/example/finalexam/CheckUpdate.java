package com.example.finalexam;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class CheckUpdate{
    String tableName = "checkData";

    public String getMenu(SQLiteDatabase database){
        /* Test Code *
        String sqlt = "SELECT updatetime,DATETIME((STRFTIME('%s', 'now') - 3), 'unixepoch') as test FROM checkData";
//        String sqlt = "INSERT INTO "+tableName+"(data, updatetime) values(\"Dump\", DATETIME((STRFTIME('%s', 'now') - 100000), 'unixepoch'));"
        Cursor c = database.rawQuery(sqlt, null);
        Log.i("DB :","Count: " + c.getCount() + "\n");

        while (c.moveToNext()){
            String data = c.getString(c.getColumnIndex("updatetime"));
            String test = c.getString(c.getColumnIndex("test"));
            Log.i("DB :","updatetime : " + data + "\n" + test + "\n");
        }
        /* Test Code */
        if(database != null){
            String sql = "SELECT data FROM checkData";
            Cursor cursor = database.rawQuery(sql, null);
            if (cursor.getCount() > 0){
                cursor.moveToNext();
//                Log.i("\nGet Data From DB : ", cursor.getString(cursor.getColumnIndex("data")));
                return cursor.getString(0);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private void UpdateData(final SQLiteDatabase database){
        final String[] d = {null};
        /* GetData */
        GetData httpReq = new GetData();
        httpReq.post(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("Something Wrong :",e.toString());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    d[0] = response.body().string();
                } else {
                    Log.d("Respons ", "error" + response.toString());
                }
                while(d[0] == null){}

                if(database != null){
                    String sql = "UPDATE "+tableName+" SET data = (?), updatetime = CURRENT_TIMESTAMP";
//                    "INSERT INTO "+tableName+"(data) VALUES (?)";
                    Log.i("\n 2. data[0] : ",  d[0]);
                    Object[] params = {d[0]};
                    database.execSQL(sql,params);
                }
            }
        });
        /* GetData */
    }

    public boolean UpdateCheck(SQLiteDatabase database){
        if(database != null) {
            String sql = "SELECT updatetime FROM "+tableName+" WHERE updatetime < DATETIME((STRFTIME('%s', 'now') - 3600), 'unixepoch')";
            Cursor cursor = database.rawQuery(sql, null);
            String Tests = String.valueOf(cursor.getColumnIndex("updatetime"));
            int Test = cursor.getCount();
            if(Test < 0){
                //Do Not Updatex
                cursor.close();
                return true;
            } else {
                //Do Update
                UpdateData(database);
                cursor.close();
                return true;
            }
        } else {
            return false;
        }
    }
}
