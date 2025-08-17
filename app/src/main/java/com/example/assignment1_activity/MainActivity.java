package com.example.assignment1_activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.assignment1_activity.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private com.example.assignment1_activity.CountryAdapter adapter;
    private CountryDatabase db;
    private List<Country> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = CountryDatabase.getInstance(this);

        if (db.countryDao().getAllCountries().isEmpty()) {
            db.countryDao().insert(new Country("Palestine", "Jerusalem", "Middle East", R.drawable.flag_palestine));
            db.countryDao().insert(new Country("Yemen", "Sanaa", "Middle East", R.drawable.flag_yemen));
            db.countryDao().insert(new Country("Singapore", "singapore", "South East Asia", R.drawable.singapore_flag));
        }

        countryList = db.countryDao().getAllCountries();
        adapter = new CountryAdapter(this, countryList);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        countryList.clear();
        countryList.addAll(db.countryDao().getAllCountries());
        adapter.notifyDataSetChanged();
    }
}
