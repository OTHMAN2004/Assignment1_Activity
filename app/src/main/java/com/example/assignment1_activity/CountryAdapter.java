package com.example.assignment1_activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.assignment1_activity.databinding.ItemCountryBinding;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private Context context;
    private List<Country> countryList;

    public CountryAdapter(Context context, List<Country> countryList) {
        this.context = context;
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCountryBinding binding = ItemCountryBinding.inflate(LayoutInflater.from(context), parent, false);
        return new CountryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countryList.get(position);
        holder.binding.countryNameTv.setText(country.getName());
        holder.binding.countryCapitalTv.setText(country.getCapital());
        holder.binding.countryFlagIv.setImageResource(country.getFlagResId());

        holder.binding.getRoot().setOnClickListener(v -> {
            Intent intent = new Intent(context, CountryDetailActivity.class);
            intent.putExtra("country", country);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() { return countryList.size(); }

    public void updateCountries(List<Country> newList) {
        countryList.clear();
        countryList.addAll(newList);
        notifyDataSetChanged();
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        ItemCountryBinding binding;
        public CountryViewHolder(@NonNull ItemCountryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
