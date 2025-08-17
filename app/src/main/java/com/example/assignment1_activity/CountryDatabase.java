package com.example.assignment1_activity;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Country.class}, version = 1)
public abstract class CountryDatabase extends RoomDatabase {
    public abstract CountryDao countryDao();
    private static CountryDatabase instance;

    public static synchronized CountryDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            CountryDatabase.class,
                            "country_db"
                    ).allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
