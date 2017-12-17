package com.example.finalexam;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class DivideData {
    static String resData;
    SQLiteDatabase database;
    CheckUpdate check = new CheckUpdate();

    DivideData(SQLiteDatabase database){
        this.database = database;
    }

    public String run(){
        if(check.UpdateCheck(database)){    // return true is update check
//        if(false){
            resData = check.getMenu(database);
            return resData;
        } else {    // return false is database fail. Do request directly
            GetData httpReq = new GetData();
            httpReq.post(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.d("Something Wrong :",e.toString());
                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (response.isSuccessful()){
                        resData = response.body().string();
                    } else {
                        Log.d("Respons ", "error" + response.toString());
                    }
                }
            });
            while(resData == null){}
            return resData;
        }
    }
}
