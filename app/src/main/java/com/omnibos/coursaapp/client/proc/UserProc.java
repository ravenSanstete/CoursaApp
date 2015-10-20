package com.omnibos.coursaapp.client.com.omnibos.coursaapp.client.proc;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.omnibos.coursaapp.client.com.omnibos.coursaapp.client.entity.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;

/**
 * Created by apple on 15/10/19.
 */
public class UserProc {
    private RequestQueue queue;
    private Context originContext;
    private final String pURL="http://192.168.1.104:4000/u";




    /*for user login action*/
    public void login(User user,Context context,Response.Listener<JSONObject> success,Response.ErrorListener fail){
        if(queue==null||originContext!=context) {
            queue = Volley.newRequestQueue(context);
            originContext = context;
        }

        final JSONObject jsonObject=user.toJson();
        Log.v("json:", jsonObject.toString());
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST,pURL+"?action=login",jsonObject,success,fail);
        queue.add(jsonObjectRequest);
    }


    public void testGet(Context context){
        if(queue==null||originContext!=context) {
            queue = Volley.newRequestQueue(context);
            originContext = context;
        }

        StringRequest stringRequest = new StringRequest(pURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Hello:", response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Hello:", error.getMessage(), error);
            }
        });

        queue.add(stringRequest);
    }




}
