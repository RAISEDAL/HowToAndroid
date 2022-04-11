package ca.dal.cs.csci3130.android_advanced.recycler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ca.dal.cs.csci3130.android_advanced.R;
import ca.dal.cs.csci3130.android_advanced.googlemap.GoogleMapsActivity;

public class RecyclerActivity extends AppCompatActivity implements MyRecyclerAdapter.ItemClickListener {

    public static final String MY_PREFS = "MY_PREFS";
    MyRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        this.loadSmallTasks();
    }

    protected void store2SharedPrefs(ArrayList<String> tasks) {
        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for (int i = 0; i < tasks.size(); i++) {
            if (i % 2 == 0) {
                editor.putString(tasks.get(i), "Halifax");
            } else {
                editor.putString(tasks.get(i), "Dhaka");
            }
        }
        //also add the lat long
        editor.putString("Halifax", "44.65,-63.58");
        editor.putString("Dhaka", "23.81,90.41");
        editor.apply();
    }

    protected void loadSmallTasks() {
        ArrayList<String> tasks = new ArrayList<String>();
        tasks.add("Walk a Dog");
        tasks.add("Pickup Grocery");
        tasks.add("Repair Computer");
        tasks.add("Babysitting");
        tasks.add("Mow the Lawn");

        this.store2SharedPrefs(tasks);

        RecyclerView recyclerView = findViewById(R.id.taskRecycleView);
        LinearLayoutManager loManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                loManager.getOrientation());
        recyclerView.setLayoutManager(loManager);
        recyclerView.addItemDecoration(dividerItemDecoration);
        this.adapter = new MyRecyclerAdapter(this, tasks);
        this.adapter.setItemClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    protected void showDetails(String selectedTask) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("selectedItem", selectedTask);
        startActivity(intent);
    }

    protected void showOnMap(String selectedTask) {
        Intent intent = new Intent(this, GoogleMapsActivity.class);
        intent.putExtra("taskLocation", "-44,63");
        startActivity(intent);
    }

    @Override
    public void onItemClick(View view, int position) {
        //Toast.makeText(this, this.adapter.getItem(position), Toast.LENGTH_LONG).show();
        showDetails(this.adapter.getItem(position));
        //showOnMap(this.adapter.getItem(position));
    }
}