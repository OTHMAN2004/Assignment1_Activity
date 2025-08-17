package com.example.assignment1_activity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;

@Entity
public class Country implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String capital;
    private String description;
    private int flagResId;

    public Country(String name, String capital, String description, int flagResId) {
        this.name = name;
        this.capital = capital;
        this.description = description;
        this.flagResId = flagResId;
    }


    public int getId() {
        return id; }

    public void setId(int id) {
        this.id = id; }

    public String getName() {
        return name; }

    public void setName(String name) {
        this.name = name; }

    public String getCapital() {
        return capital; }

    public void setCapital(String capital) {
        this.capital = capital; }

    public String getDescription() {
        return description; }

    public void setDescription(String description) {
        this.description = description; }

    public int getFlagResId() {
        return flagResId; }

    public void setFlagResId(int flagResId) {
        this.flagResId = flagResId; }
}
