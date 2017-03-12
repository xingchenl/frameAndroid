package com.example.xingchen.basedevelop.util;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import de.greenrobot.event.EventBus;

/**
 * Created by xingchen on 2017/3/12.
 */

public class VolleysPostString {
    String url;
    Context context;
    public VolleysPostString(String url,Context context){
        this.url=url;
        this.context=context;
    }

    public void post(){

        RequestQueue mQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        EventBus.getDefault().post(new EventMess(response));
                        Log.e("zzzzzzzzzzzzzzzzzz",response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });

        mQueue.add(stringRequest);


    }
}
