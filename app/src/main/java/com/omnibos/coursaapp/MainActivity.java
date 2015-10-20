package com.omnibos.coursaapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.omnibos.coursaapp.client.com.omnibos.coursaapp.client.entity.User;
import com.omnibos.coursaapp.client.com.omnibos.coursaapp.client.proc.ClientProc;
import com.omnibos.coursaapp.client.com.omnibos.coursaapp.client.proc.UserProc;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Spinner mSpinner;
    private static final String[] foo_array={"请选择","lame","super lame"};
    private ArrayAdapter<String> adapter;

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpinner = (Spinner)findViewById(R.id.foo_spinner);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,foo_array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!foo_array[position].equals("请选择"))
                    Toast.makeText(MainActivity.this, foo_array[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User a_usr = new User();
                a_usr.setUsername("sanstete");
                a_usr.setPassword("123456");

                ClientProc.User.login(a_usr, getApplicationContext(), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        try {
                            Log.v("Uid:", jsonObject.getString("uid"));
                            Log.v("State:", jsonObject.getString("state"));
                        } catch (JSONException ex) {
                            ex.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.v("Volley Error:", volleyError.toString());
                    }
                });

                ClientProc.User.testGet(getApplicationContext());

            }
        });
        /*for test*/



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}