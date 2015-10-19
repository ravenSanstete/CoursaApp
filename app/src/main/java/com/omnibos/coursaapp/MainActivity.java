package com.omnibos.coursaapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.omnibos.coursaapp.client.com.omnibos.coursaapp.client.entity.User;
import com.omnibos.coursaapp.client.com.omnibos.coursaapp.client.proc.UserProc;

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
                User a_usr=new User();
                a_usr.setUid("394018349");
                a_usr.setPassword("2323523");

                UserProc.login(a_usr,getBaseContext());

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