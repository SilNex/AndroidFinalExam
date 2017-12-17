package com.example.finalexam;

import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

class GetData {
    OkHttpClient client = new OkHttpClient();

    Call post(Callback callback){
//        Log.i("GetData Call", "OK");
        Request request = new Request.Builder().url("http://menu.silnex.kr").build();

        Call call = client.newCall(request);
        call.enqueue(callback);
        return  call;
    }

    Call PlanktonPost(Callback callback){
        Log.i("Plankton", "PostOK");
        Request request = new Request.Builder().url("http://menu.silnex.kr").build();

        Call call = client.newCall(request);
        call.enqueue(callback);
        return  call;
    }
}
