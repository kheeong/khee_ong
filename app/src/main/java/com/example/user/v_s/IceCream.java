package com.example.user.v_s;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.user.v_s.R.id.button;

public class IceCream extends AppCompatActivity {
    ListView search_food;
    ArrayAdapter<String> adapter;
    Class x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ice_cream);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IceCream.this, Compare.class);
            }
        });
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
                    if (String.valueOf(adapter.getItem(position)).equals("Oreo Ice Cream")) {
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
