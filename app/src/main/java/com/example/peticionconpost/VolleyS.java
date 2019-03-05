package com.example.peticionconpost;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyS {

    private static VolleyS volley=null;
    private RequestQueue requestQueue;

    private VolleyS(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }


    public static VolleyS getVolley(Context context) {

        if (volley==null)
        {
            volley =new VolleyS (context);
        }
        return volley;
    }



}
