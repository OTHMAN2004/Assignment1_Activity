package com.example.assignment1_activity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CountryDao {
    @Insert void insert(Country country);
    @Update void update(Country country);
    @Delete void delete(Country country);
    @Query("SELECT * FROM Country")
    List<Country> getAllCountries();
}
