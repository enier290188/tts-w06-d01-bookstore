package com.tts.w06.conveniencestore;

import com.tts.w06.Utils;

import java.io.IOException;
import java.util.ArrayList;

public class ConvenienceStore {
    private String name;
    private String address;
    private ArrayList<String> titles;

    public ConvenienceStore() {
        this.name = "";
        this.address = "";
        // init the array and then load it.
        titles = new ArrayList<String>();
        this.loadTitles();
    }

    public ConvenienceStore(String name, String address) {
        this.name = name;
        this.address = address;
        // init the array and then load it.
        titles = new ArrayList<String>();
        this.loadTitles();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private void loadTitles() {
        try {
            Utils.loadStringsToArray(this.titles, "src/com/tts/w06/conveniencestore/ConvenienceTitles.txt");
        } catch (IOException e) {
            // for now simply init the array to zero
            System.out.println("Could not initialize the titles");
            // make sure it is empty
            this.titles = new ArrayList<String>();
        }
    }

    public ArrayList<String> getTitles() {
        return titles;
    }

    // Know the total number of conveniences the store has.
    public int totalOfConveniences() {
        return this.titles.size();
    }
}
