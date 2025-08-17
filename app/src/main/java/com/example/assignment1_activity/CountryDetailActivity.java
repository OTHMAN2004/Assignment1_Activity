package com.example.assignment1_activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment1_activity.databinding.ActivityCountryDetailBinding;

public class CountryDetailActivity extends AppCompatActivity {

    private ActivityCountryDetailBinding binding;
    private Country country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCountryDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        country = (Country) getIntent().getSerializableExtra("country");

        if (country != null) {
            binding.countryFlagIv.setImageResource(country.getFlagResId());
            binding.countryNameTv.setText(country.getName());
            binding.countryCapitalTv.setText(country.getCapital());
            binding.txtDescription.setText(country.getDescription());
        }

        binding.editBt.setOnClickListener(v -> showEditDialog());
        binding.deleteBt.setOnClickListener(v -> showDeleteDialog());
    }

    private void showEditDialog() {
        EditText input = new EditText(this);
        input.setText(country.getDescription());
        new AlertDialog.Builder(this)
                .setTitle("Edit Country")
                .setMessage("Update description for " + country.getName())
                .setView(input)
                .setPositiveButton("Save", (dialog, which) -> {
                    country.setDescription(input.getText().toString());
                    CountryDatabase.getInstance(this).countryDao().update(country);
                    binding.txtDescription.setText(country.getDescription());
                    Toast.makeText(this, "Updated!", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    private void showDeleteDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Delete Country")
                .setMessage("Are you sure you want to delete " + country.getName() + "?")
                .setPositiveButton("Delete", (dialog, which) -> {
                    CountryDatabase.getInstance(this).countryDao().delete(country);
                    finish();
                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}
