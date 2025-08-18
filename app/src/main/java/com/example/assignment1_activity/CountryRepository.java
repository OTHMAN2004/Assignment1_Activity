package com.example.assignment1_activity;

import android.app.Application;
import java.util.List;

public class CountryRepository {
    private CountryDao countryDao;

    public CountryRepository(Application application) {
        CountryDatabase db = CountryDatabase.getInstance(application);
        countryDao = db.countryDao();
    }

    public List<Country> getAllCountries() {
        return countryDao.getAllCountries();
    }

    public void insert(Country country) {
        countryDao.insert(country);
    }


    public void update(Country country) {
        countryDao.update(country);
    }

    public void delete(Country country) {
        countryDao.delete(country);
    }
}
