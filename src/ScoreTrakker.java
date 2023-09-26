/**
 * ScoreTrakker - A Java program for processing and displaying student scores.
 * Authors: Jonathan Nunez Toledo, Calvin Tran
 *
 * Description:
 * This program reads student data from text files, processes the information, and
 * prints the student records in sorted order based on their scores.
 *
 * References:
 * 1. Sorting ArrayList in Java - https://www.javatpoint.com/how-to-sort-arraylist-in-java
 * 2. Scanner hasNextLine() Method in Java - https://www.geeksforgeeks.org/scanner-hasnextline-method-in-java-with-examples/
 * 3. Collections in Java - https://www.javatpoint.com/collections-in-java
 * 4. Java IOException Documentation - https://docs.oracle.com/javase/8/docs/api/java/io/IOException.html
 * 5. Using the 'finally' Block for Catching Exceptions - https://www.geeksforgeeks.org/java-program-to-use-finally-block-for-catching-exceptions/
 * 6. Understanding the printStackTrace() Method in Java - https://www.educative.io/answers/what-is-the-printstacktrace-method-in-java
 */

import java.util.ArrayList;
import java.io.FileReader;
import java.util.Collections;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

class ScoreTrakker {
    private ArrayList<Student> students = new ArrayList<Student>(); 
    private String[] files = {"scores.txt", "badscores.txt", "nofile.txt" }; 

    public ScoreTrakker() {
        students = new ArrayList<>(); 
    }

    public void loadDataFile(String fileName) throws IOException {
        String line = "";
        FileReader reader = null;
        Scanner scanner = null;

        try {
            reader = new FileReader(fileName); // Open the specified file for reading
            scanner = new Scanner(reader); // Create a Scanner to read from the file
            while (scanner.hasNextLine()) {
                String name = scanner.nextLine(); // Read student name from the file
                String scoreError = scanner.nextLine(); // Read potential score error message
                try {
                    int score = Integer.parseInt(scoreError); // Parse and read student score
                    students.add(new Student(name, score)); // Create a Student object and add it to the ArrayList
                } catch (NumberFormatException e) {
                    // Handle the case where the score is not a valid integer
                    System.out.println("Incorrect Format for " + name + " not a valid score: " + scoreError);
                }
            }
        } catch (IOException e) {
            // Handle the case where the file cannot be opened
            System.out.println("Can't open file: " + fileName);
        } finally {
            // Close the file and scanner regardless of whether there was an exception
            if (scanner != null) {
                scanner.close();
            }
            if (reader != null) {
                reader.close();
            }
        }
    }
    

    public void printInOrder() {
        Collections.sort(students); // Sort the students ArrayList based on their scores
        for (Student student : students) {
            System.out.println(student); // Print the students in sorted order
        }
    }

    public void processFiles() {
        for (String fileName : files) {
            try {
                loadDataFile(fileName); // Load data from each file
                if (!students.isEmpty()) {
                    System.out.println("Student Score List");
                    printInOrder();
                }            
                System.out.println();
            } catch (FileNotFoundException e) {
                // Handle the case where the file is not found
                System.out.println("File not found: " + fileName);
            } catch (IOException e) {
                // Handle the case where there is an error processing the file
                System.out.println("Error processing file: " + fileName);
            } finally {
                // Clear the students list for the next file
                students.clear();
            }
        }
    }

    public static void main(String[] args) {
        ScoreTrakker scoreTrakker = new ScoreTrakker();
        scoreTrakker.processFiles(); // Start processing the specified files
    }
}
