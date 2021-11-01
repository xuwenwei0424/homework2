package com.example.w2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //    private String[] searcoh = {"hhhhh","cccccc","wwwwww","ddddd","aaaaa"};
    private List<String> searcoh = new ArrayList<>();
    private SearchView main_searchview;
    private ListView main_listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 100; i ++){
            String s = "这里是第" + String.valueOf(i) + '行';
//            String s = String.valueOf(i);
            searcoh.add(s);
        }
        findViews();
    }

    private void findViews(){
        main_searchview = (SearchView) findViewById(R.id.main_searchview);
        main_listview = (ListView) findViewById(R.id.main_listview);
        main_listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, searcoh));
        main_listview.setTextFilterEnabled(true);
        main_searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)){
//                    newText = "这里是第" + newText + '行';
                    main_listview.setFilterText(newText);
                }   else {
                    main_listview.clearChoices();
                }
                return false;
            }
        });
    }
}
