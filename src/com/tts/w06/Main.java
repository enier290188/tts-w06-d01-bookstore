package com.tts.w06;

public class Main {

    public static void main(String[] args) {
        simulatedInteractionWithABookstore();
    }

    public static void simulatedInteractionWithABookstore() {
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
        System.out.println();
        System.out.println("- Books:");
        for (String title : bookstore.getTitles()) {
            System.out.println("\t- " + title);
        }
        System.out.println("- Know the total number of books the store has: " + bookstore.totalOfBooks());
        System.out.println("- See if the store has a specific title: " + "Cucumber and Gherkin for Java: " + bookstore.hasTitle("Cucumber and Gherkin for Java"));
        System.out.println("- A word appears anywhere in a title: " + "Java: " + bookstore.wordAppearAnywhereInATitle("Java"));
    }
}
