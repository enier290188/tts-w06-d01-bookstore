package com.tts.w06;

import com.tts.w06.bookstore.BookStore;
import com.tts.w06.coffeeshop.CoffeeShop;
import com.tts.w06.conveniencestore.ConvenienceStore;
import com.tts.w06.sandwichshop.SandwichShop;

public class Main {

    public static void main(String[] args) {
        simulatedInteractionWithABookStore();
        simulatedInteractionWithACoffeeShop();
        simulatedInteractionWithASandwichShop();
        simulatedInteractionWithAConvenienceStore();
    }

    public static void simulatedInteractionWithABookStore() {
        System.out.println("Book Store:");
        /*
            Create a bookstore
            Set the appropriate properties
            Answer the following questions:
                    What is the address?
                    Is the store open today?
                    What time does it close?
                    How big is the store?
                    Does the store have new or used books?
         */
        BookStore bookstore = new BookStore();
        bookstore.setName("Alba");
        bookstore.setAddress("Nelson Drive #68");
        bookstore.setSquareFeet(100);
        bookstore.setOpenToday(true);
        bookstore.setOpenToday(true);
        System.out.println("- What is the address? : " + bookstore.getAddress());
        System.out.println("- Is the store open today? : " + bookstore.isOpenToday());
        System.out.println("- What time does it close? : " + bookstore.getDailyClosingTime());
        System.out.println("- How big is the store? : " + bookstore.getSquareFeet() + " square feet");
        System.out.println("- Does the store have new or used books? : " + bookstore.isHasUsedBooks());
        //
        System.out.println("- Books:");
        for (String title : bookstore.getTitles()) {
            System.out.println("\t- " + title);
        }
        System.out.println("- Know the total number of books the store has: " + bookstore.totalOfBooks());
        System.out.println("- See if the store has a specific title: " + "Cucumber and Gherkin for Java: " + bookstore.hasTitle("Cucumber and Gherkin for Java"));
        System.out.println("- A word appears anywhere in a title: " + "Java: " + bookstore.wordAppearAnywhereInATitle("Java"));
        System.out.println();
    }

    public static void simulatedInteractionWithACoffeeShop() {
        System.out.println("Coffee Shop:");
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.setName("Albania");
        coffeeShop.setAddress("Nelson Drive #60");
        System.out.println("- Coffees:");
        for (String title : coffeeShop.getTitles()) {
            System.out.println("\t- " + title);
        }
        System.out.println("- Know the total number of coffees the shop has: " + coffeeShop.totalOfCoffees());
        System.out.println();
    }

    public static void simulatedInteractionWithASandwichShop() {
        System.out.println("Sandwich Shop:");
        SandwichShop sandwichShop = new SandwichShop();
        sandwichShop.setName("Rito");
        sandwichShop.setAddress("Nelson Drive #61");
        System.out.println("- Sandwiches:");
        for (String title : sandwichShop.getTitles()) {
            System.out.println("\t- " + title);
        }
        System.out.println("- Know the total number of sandwiches the shop has: " + sandwichShop.totalOfSandwiches());
        System.out.println();

    }

    public static void simulatedInteractionWithAConvenienceStore() {
        System.out.println("Convenience Store:");
        ConvenienceStore convenienceStore = new ConvenienceStore();
        convenienceStore.setName("Rem");
        convenienceStore.setAddress("Nelson Drive #62");
        System.out.println("- Conveniences:");
        for (String title : convenienceStore.getTitles()) {
            System.out.println("\t- " + title);
        }
        System.out.println("- Know the total number of conveniences the store has: " + convenienceStore.totalOfConveniences());
        System.out.println();
    }
}
