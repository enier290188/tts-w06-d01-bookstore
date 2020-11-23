package com.tts.w06.bookstore;

import com.tts.w06.Utils;

import java.io.IOException;
import java.util.ArrayList;

public class BookStore {
    private String name;
    private String address;
    private int squareFeet;
    private boolean hasUsedBooks;
    private boolean isOpenToday;
    private String dailyOpeningTime;
    private String dailyClosingTime;
    private ArrayList<String> titles;

    public BookStore() {
        this.name = "";
        this.address = "";
        this.squareFeet = 0;
        this.hasUsedBooks = false;
        this.isOpenToday = false;
        this.dailyOpeningTime = "8:00am-5:00pm";
        this.dailyClosingTime = "5:01pm-7:00am";
        // init the array and then load it.
        titles = new ArrayList<String>();
        this.loadTitles();
    }

    public BookStore(String name, String address, int squareFeet, boolean hasUsedBooks, boolean isOpenToday) {
        this.name = name;
        this.address = address;
        this.squareFeet = squareFeet;
        this.hasUsedBooks = hasUsedBooks;
        this.isOpenToday = isOpenToday;
        // init the array and then load it.
        titles = new ArrayList<String>();
        this.loadTitles();
    }

    public BookStore(String name, String address, int squareFeet, boolean hasUsedBooks, boolean isOpenToday, String dailyOpeningTime, String dailyClosingTime) {
        this.name = name;
        this.address = address;
        this.squareFeet = squareFeet;
        this.hasUsedBooks = hasUsedBooks;
        this.isOpenToday = isOpenToday;
        this.dailyOpeningTime = dailyOpeningTime;
        this.dailyClosingTime = dailyClosingTime;
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

    public int getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(int squareFeet) {
        this.squareFeet = squareFeet;
    }

    public boolean isHasUsedBooks() {
        return hasUsedBooks;
    }

    public void setHasUsedBooks(boolean hasUsedBooks) {
        this.hasUsedBooks = hasUsedBooks;
    }

    public boolean isOpenToday() {
        return isOpenToday;
    }

    public void setOpenToday(boolean openToday) {
        isOpenToday = openToday;
    }

    public String getDailyOpeningTime() {
        return dailyOpeningTime;
    }

    public void setDailyOpeningTime(String dailyOpeningTime) {
        this.dailyOpeningTime = dailyOpeningTime;
    }

    public String getDailyClosingTime() {
        return dailyClosingTime;
    }

    public void setDailyClosingTime(String dailyClosingTime) {
        this.dailyClosingTime = dailyClosingTime;
    }

    private void loadTitles() {
        try {
            Utils.loadStringsToArray(this.titles, "src/com/tts/w06/bookstore/BookTitles.txt");
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

    // Know the total number of books the store has.
    public int totalOfBooks() {
        return this.titles.size();
    }

    // See if the store has a specific title.
    public boolean hasTitle(String title) {
        for (String titleItem : this.titles) {
            if (titleItem.equals(title)) {
                return true;
            }
        }
        return false;
    }

    // A word appears anywhere in a title.
    public boolean wordAppearAnywhereInATitle(String word) {
        for (String titleItem : this.titles) {
            if (titleItem.contains(word)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Bookstore{" + "name='" + name + "'" + ", address='" + address + "'" + "}";
    }
}
