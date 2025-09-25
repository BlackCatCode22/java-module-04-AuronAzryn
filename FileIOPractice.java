// FileIOPractice.java
// aD 9/25/2025

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileIOPractice {
    public static void main(String[] args) {
        System.out.println("Hello and welcome to my File IO App!\n ");

        // create a file named something.txt
        try {
            File myObj = new File("something.txt"); // Create File object
            if (myObj.createNewFile()) {           // Try to create the file
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace(); // Print error details
        }

        // open and read arrivingAnimals.txt
        File myObj = new File("arrivingAnimals.txt");

        // try-with-resources: Scanner will be closed automatically
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("\n This is from a buffered reader.\n");
        try (BufferedReader br = new BufferedReader(new FileReader("arrivingAnimals.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                // Parse the string named line into 6 array elements
                // use a string array to get the six elements separated by comma-space
                String[] mySixParts = line.split(regex", ");
                // output the 6 parts that were just parsed.
                System.out.println("\n mySixParts[0] is " + mySixParts[0]);
                System.out.println("\n mySixParts[1] is " + mySixParts[1]);
                System.out.println("\n mySixParts[2] is " + mySixParts[2]);
                System.out.println("\n mySixParts[3] is " + mySixParts[3]);
                System.out.println("\n mySixParts[4] is " + mySixParts[4]);
                System.out.println("\n mySixParts[5] is " + mySixParts[5]);
                System.out.println("\n mySixParts[6] is " + mySixParts[6]);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}

