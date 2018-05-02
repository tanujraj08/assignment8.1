package com.tanuj.ascendingdescending;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    Button btnAscending, btnDescending;
    ListView monthNameListView;
    ArrayList<String> monthNamesArrayList;
    ArrayAdapter<String> monthNamesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAscending = (Button) findViewById(R.id.btnAscending);
        btnDescending = (Button) findViewById(R.id.btnDescending);
        monthNameListView = (ListView) findViewById(R.id.monthNamesListView);

        initializeListViewWithArrayListAndAdapter();

        if (btnAscending != null) {
            btnAscending.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changeListViewSortOrder(view);
                }
            });
        }

        if (btnDescending != null) {
            btnDescending.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changeListViewSortOrder(view);
                }
            });
    }
}

    private void changeListViewSortOrder(View view){
        final View buttonView = view;

        Collections.sort(monthNamesArrayList, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                if (buttonView.getTag().equals("1"))
                    return s.compareTo(t1);
                else
                    return t1.compareTo(s);
            }
        });
        monthNamesAdapter.notifyDataSetChanged();
    }

    private void initializeListViewWithArrayListAndAdapter(){
        monthNamesArrayList = new ArrayList<String>();
        monthNamesArrayList.add("January");
        monthNamesArrayList.add("February");
        monthNamesArrayList.add("March");
        monthNamesArrayList.add("April");
        monthNamesArrayList.add("May");
        monthNamesArrayList.add("June");
        monthNamesArrayList.add("July");
        monthNamesArrayList.add("August");
        monthNamesArrayList.add("September");
        monthNamesArrayList.add("October");
        monthNamesArrayList.add("November");
        monthNamesArrayList.add("December");

        monthNamesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,monthNamesArrayList);
        monthNameListView.setAdapter(monthNamesAdapter);
    }
}

