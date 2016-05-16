package com.example.kripzy.champgg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SearchView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    GridView gv;
    SearchView sv;
    Context a;
    String[] Champions = {"Aatrox", "Ahri", "Akali"};
    int[] Champimgs = {R.drawable.aatrox_square_0, R.drawable.ahri_square_0, R.drawable.akali_square_0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // SearchView searchView = (SearchView) findViewById(R.id.search_bar);
       // searchView.setIconified(false);
       // searchView.clearFocus();


        GridView gv = (GridView) findViewById(R.id.gridView);
        gv = (GridView) findViewById(R.id.gridView);
        sv = (SearchView) findViewById(R.id.searchView);


        final Adapter adapter = new Adapter(this, this.getChampions());
        gv.setAdapter(adapter);


        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String arg0) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {

                adapter.getFilter().filter(query);

                return false;
            }
        });

        //gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //@Override
           // public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


               // }
        Activity savedContext;

        //});

    }

    private ArrayList<Champions> getChampions() {
        ArrayList<Champions> champions = new ArrayList<Champions>();
        Champions p;

        for (int i = 0; i < Champions.length; i++) {
            p = new Champions(Champions[i], Champimgs[i]);
            champions.add(p);
        }
        return champions;
    }
}


