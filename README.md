# TTS: Week 06, Day 01. Bookstore.

The following instructions are to follow the lecture on classes and objects.  These should be done in a tool that allows for immediate compilation as some of the instructions will be to enter something that will break.  This is in order to see how the compiler enforces some of the language rules.   There will also be heavy use of the the `System.out.println()` method to see the results once the code compiles.

Keep in mind the instruction *can* be written in a plan text editor and then compiled on the command line using `javac` but the process will be much slower.  

#### Java JDK
The first thing to do is to learn about the JDK packages and classes.  

These can be found [here](https://docs.oracle.com/javase/8/docs/api/overview-summary.html) for version 8.  Depending on which version of Java you're using for the class the documentation for [version 11](https://docs.oracle.com/en/java/javase/11/docs/api/index.html) or [version 12](https://docs.oracle.com/en/java/javase/12/docs/api/index.html) may be more appropriate.  The following instructions will be based on Java 8, but you are encouraged to explore the release notes for all versions, especially 11 and 12, to see what functionality has been added. Versions 11 and 12 have a concept known as Modules which is an attempt to reduce the size of deployed applications. Essentially this is a way to group common packages together - logically a superset of packages.  However at the time of this writing, even though versions 11 and 12 have been released, version 8 is still the most widely used version.  

Given the link to the version 8 documentation above, go look up the classes in the `java.lang` package.  Remember, these will not have to be specifically imported.  For now look only at the classes section; the other values such as Interfaces and Exceptions will be covered in a later lesson.

How many sub-packages are beneath `java.lang`?

Look at the following packages

* java.nio 
* java.text
* java.net 
* java.nio.files
* java.math
* java.time

Familiarize yourself with these packages. Note that you may see dupicate class names in different packages, or classes that seem to directly conflict with others - which should you use?  
In general that question should be answered in the documentation itself, as older classes may have some verbiage that they are "deprecated".  One of these apparent conflicts that has gotten quite a bit of attention is the classes dealing with `Date` and `Time`.

In the `java.util` package there is a class called `Date` and a supporting class called `Calendar`.  It would seem that these would be adequate for handling operations dealing with dates and times, however since their initial release many shortcomings have been identified.  So many that a completely new package and classes were included in the Java 8 version; these are located in the `java.time` package.  All date and time usage should use classes in `java.time` but there may be legacy code that uses the older `java.util.Date` class.  

### User Defined Class
Create a simple Java project with a single class that contains a main file. 

Now create a new Java class and call it `Bookstore`.  What attributes should a class modeling a book store have?  Here are a few suggestions:
* Name
* Address
* Square Feet
* Has used books?
* Open?
* Open on Weekends?
* Open on Sundays?
* Daily Opening time.
* Daily Closing time.

What others?

Create the attributes for the class along with the appropriate accessor methods.  Create several overloaded constructors as well.  Question - what are the most common ways to create a store?  Do all of the properties need to be specified?  Meaning should there be one default constructor and one with a name (two total)?  Recall that any properties not provided as arguments to the constructor will either be set to their default type value or can be explicitly set to appropriate defaults. 

Use the BookStore class in the `main` method to model a simulated interaction with a bookstore.  Note that all 'interaction' will simply be printing messages to the console.
* Create a bookstore
* Set the appropriate properties
* Answer the following questions:
  - What is the address?
  - Is the store open today?
  - What time does it close?
  - How big is the store?
  - Does the store have new or used books?

But what is a book store with no books? The next section of code will include some snippets to read a list of books from a file.  The instructions will as generic as possible, but you may have to adjust some entries regarding the path to the file.

In the example a text file should be put in the root of the project. It should have as entries simply the names of some books.  An example "Bookfile.txt" contains:
```
Programming in Java
Java Pearls
Database Design
Practical Enterprise Software Development Techniques
Just Enough Database
Just Enough Debugging
Just Enough Requirements and Documentation
Python Crash Course
Cucumber and Gherkin for Java 
Machine Learning with Python

```
In the lesson on classes we briefly discussed the ArrayList class.  While the full extent of the collection classes will be discussed in the lecture on data structures, there is enough presented so far to use this class to contain a list of titles.

The following code will walk through the loading of titles from disk. Note that the process of importing the correct packages is not described, that can be done either via the IDE or using the Oracle Java documentation to find the correct package and manually typing the import statement.  

First, declare a private member to hold the list of titles:
```java
private ArrayList<String> titles;
```
Next, create a class called `Utils` to hold utility methods.  This is the class that will have a method to ready the titles from a disk file.  The definition of the class should be:
```java
public class Utils
{
  public static void loadStringsToArray(ArrayList<String> arrList) throws IOException
  {
    Path path = Paths.get("BookTitles.txt");
    arrList.clear();

    // The stream file will also be closed here
    try (Stream<String> lines = Files.lines(path))
    {
      Object[] arr = lines.toArray();

      for(Object t: arr)
      {
        arrList.add(t.toString());
      }
    }
  }

}
```
For now the explicit details of this method do not need to be totally understood, but it is actually a very simple method.  It takes an array of strings, ensures that the list is empty, and then loads the lines of the text file and makes each line an item in the list.  

*NOTE:* The one item that may cause an issue, as described above, the the file path.  The path specified in the code above assumes the file is located in the root of the project.  Depending on your IDE and project structure it may be in a different location so that may have to be adjusted.  If all else fails, the file can be moved to a location outside of the project and found explicitly = 

```java
Path path = Paths.get("c:\\data\\BookTitles.txt");  // Windows OS location
```
So now this load method should be called during the initialization of the class. Add a private method to the class to do jus that:
```java
private void loadTitles()
{
  try
  {
    Utils.loadStringsToArray(this.titles);
  }
  catch (IOException e)
  {
    // for now simply init the array to zero
    System.out.println("Could not initilize the titles");
    // make sure it is empty
    this.titles = new ArrayList<String>();
    
  }
}
```
And this method can now be called inside of the constructor to load the titles:
```java
public Bookstore(String name, String address)
{
  this.name = name;
  this.address = address;

  // all other members set here

  // init the array and then load it.
  titles = new ArrayList<String>();
  loadTitles();
}
```

So now that the private pieces of information have been implemented for the books, what should be exposed to the user of the class?  It doesn't seem like a bookstore should provide getter/setter for the entire array.  But maybe the user would like to know the total number of books the store has.  Or perhaps to see if the store has a specific title.  Or if a word appears anywhere in a title.  Code each of these as public methods in the Bookstore class.

Take the concepts that applied to the Bookstore and make a couple of more store classes.
* Sandwich Shop
* Coffee Shop
* Convenience Store


Think about how to model each one and what are the important attributes and methods.