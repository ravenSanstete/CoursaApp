package com.omnibos.coursaapp.client.com.omnibos.coursaapp.client.proc;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.omnibos.coursaapp.client.com.omnibos.coursaapp.client.entity.User;

import org.json.JSONObject;

import java.lang.reflect.Method;

/**
 * Created by apple on 15/10/19.
 */
public class UserProc {
    private static RequestQueue queue;
    private static Context originContext;
    private static final String URL="http://192.168.1.104:4000/u";
    public static String login(User user,Context context){
        if(queue==null||originContext!=context) {
            queue = Volley.newRequestQueue(context);
            originContext = context;
        }

        Log.v("here:","***********************");

        JSONObject jsonObject=user.toJson();
        Log.v("json:",jsonObject.toString());
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST,URL,jsonObject,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //打印请求后获取的json数据
                Log.v("bbb", response.toString());

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError arg0) {
                // System.out.println("sorry,Error");
                Log.v("aaa", arg0.toString());
            }
        });


        queue.add(jsonObjectRequest);

        return "";
    }


}
