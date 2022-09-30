package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<String> array;
    Button btnThem;
    EditText editMon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnThem = (Button) findViewById(R.id.button3);
        editMon = (EditText) findViewById(R.id.edtMon);
        lv = (ListView) findViewById(R.id.listview);
        array = new ArrayList<>();

        array.add("Phở bò");
        array.add("Phở tái");
        array.add("Phở nạm");

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,array);
        lv.setAdapter(adapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String MonAn = editMon.getText().toString();
                array.add(MonAn);
                adapter.notifyDataSetChanged();


            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                array.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }
}