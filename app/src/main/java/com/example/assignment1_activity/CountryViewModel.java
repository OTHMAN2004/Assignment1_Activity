package com.example.assignment1_activity;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;

public class CountryViewModel extends AndroidViewModel {
    private CountryRepository repository;
    private MutableLiveData<List<Country>> countries;

    public CountryViewModel(@NonNull Application application) {
        super(application);
        repository = new CountryRepository(application);
        countries = new MutableLiveData<>();
        loadCountries();
    }

    private void loadCountries() {
        countries.setValue(repository.getAllCountries());
    }

    public LiveData<List<Country>> getCountries() { return countries; }

    public void insert(Country country) {
        repository.insert(country);
        loadCountries();
    }

    public void update(Country country) {
        repository.update(country);
        loadCountries();
    }

    public void delete(Country country) {
        repository.delete(country);
        loadCountries();
    }
}
