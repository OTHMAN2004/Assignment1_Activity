package com.example.assignment1_activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.assignment1_activity.databinding.ActivityMainBinding;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private CountryAdapter adapter;
    private CountryViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new CountryAdapter(this, new ArrayList<>());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(CountryViewModel.class);

        // Insert initial countries if empty
        if (viewModel.getCountries().getValue() == null || viewModel.getCountries().getValue().isEmpty()) {
            viewModel.insert(new Country("Palestine", "Jerusalem", "Middle East", R.drawable.flag_palestine));
            viewModel.insert(new Country("Yemen", "Sanaa", "Middle East", R.drawable.flag_yemen));
            viewModel.insert(new Country("Singapore", "Singapore", "South East Asia", R.drawable.singapore_flag));
        }

        viewModel.getCountries().observe(this, countries -> adapter.updateCountries(countries));
    }
}
