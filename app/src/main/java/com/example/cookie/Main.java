package com.example.cookie;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {

    final int NEW_LV1 = 20;
    final int NEW_LV2 = 10;

    ArrayList<String> title = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ArrayList<String> items = new ArrayList<String>();
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, items);
        ListView listview = (ListView) findViewById(R.id.LV1);
        listview.setAdapter(adapter);

        MainLV1Adapter mlv1;

        mlv1 = new MainLV1Adapter();
        listview = (ListView) findViewById(R.id.LV1);
        listview.setAdapter(mlv1);

        mlv1.addItem("2010/1/1", "Card", "Book", "50", "30");


        Button Write = (Button) findViewById(R.id.Write);
        Button Menu = (Button) findViewById(R.id.Menu);
        Button Modify = (Button) findViewById(R.id.Modify);

        Write.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Main.this, Write.class);
                startActivityForResult(intent, NEW_LV1);

            }
        });

        Menu.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(Main.this, Entry.class);
                startActivityForResult(intent2, NEW_LV2);

            }
        });

//        final ListView finalListview = listview;
//        Modify.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                int count, checked;
//                count = adapter.getCount();
//
//                if (count > 0) {
//
//                    checked = finalListview.getCheckedItemPosition();
//                    if (checked > -1 && checked < count) {
//
//                        items.set(checked, Integer.toString(checked + 1) + " 수정됨");
//                        adapter.notifyDataSetChanged();
//
//                    }
//                }
//            }
//        });

    }


}