package com.example.user.v_s;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class IceCream extends AppCompatActivity {
    ListView search_food;
    ArrayAdapter<String> adapter;
    Class x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ice_cream);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        search_food = (ListView) findViewById(R.id.search_food);

        ArrayList<String> arrayFood = new ArrayList<>();
        arrayFood.addAll(Arrays.asList(getResources().getStringArray(R.array.ICE_LIST)));

        adapter = new ArrayAdapter<String>(
                IceCream.this,
                android.R.layout.simple_list_item_1,
                arrayFood
        );
        search_food.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.search_food);
        SearchView searchView = (SearchView) item.getActionView();
        ListView listView = (ListView) findViewById(R.id.search_food);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i < 1; i++) {
                    Toast.makeText(IceCream.this, String.valueOf(adapter.getItem(position)), Toast.LENGTH_SHORT).show();
                    if (String.valueOf(adapter.getItem(position)).equals("Orea Ice Cream")) {
                        x = Oreo_Ice_Cream.class;
                    } else {
                        continue;
                    }
                    Intent intent = new Intent(IceCream.this, x);
                    startActivity(intent);
                }
            }

        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
