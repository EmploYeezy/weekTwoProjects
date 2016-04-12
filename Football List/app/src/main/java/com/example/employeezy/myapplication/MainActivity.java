package com.example.employeezy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            final EditText mEditText  = (EditText) findViewById(R.id.edit_text);
            Button add = (Button) findViewById(R.id.butAdName);
            Button remove = (Button) findViewById(R.id.butRemove);
            final ListView mStringList = (ListView) findViewById(R.id.list_view);
            final ArrayList listNames = new ArrayList<String>();
            final ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listNames);
            mStringList.setAdapter(adapter);

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listNames.add(mEditText.getText().toString());
                    mEditText.setText("");
                    adapter.notifyDataSetChanged();
                }
            });

            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listNames .size() !=0) {
                        listNames.remove(0);
                    } else {
                        System.out.println("Nope");
                    }
                    adapter.notifyDataSetChanged();
                }
            });

            mStringList.setOnItemClickListener(new AdapterView.OnItemClickListener()

            {
                @Override
                public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                    Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_LONG).show();
                }
            });

        }
    }

