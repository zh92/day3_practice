package sdf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {

    public static void main(String[] args) throws IOException {
        
        String dirPath = "data2";
        String stringLogin = "";

        File newdir = new File(dirPath);
        if (newdir.exists()) {
            System.out.println("Directory already existed");
        } else {
            newdir.mkdir();
        }

        System.out.println("Welcome to your shopping cart");

        List<String> cartItems = new ArrayList<String>();

        Console cons = System.console();
        String input = "";
        while (!input.equals("quit")) {
            input = cons.readLine("What do you like to do? (type 'help' to show list of commands)");

            if (input.equals("help")) {
                System.out.println("'list' to show a list of items in shopping cart");
                System.out.println("login <name> to access your cart");
                System.out.println("add <item name>");
                System.out.println("delete <item number>");
                System.out.println("'quit' to exit program");
            }

            //Code for login
            if(input.toLowerCase().startsWith("login")) {
                input = input.replace(",", " ");

                Scanner scanner = new Scanner(input.substring(6));

                while (scanner.hasNext()) {
                    stringLogin = scanner.next();
                }

                File loginFile = new File(dirPath + File.separator + stringLogin);
                //Create new file
                boolean isCreated = loginFile.createNewFile();

                if (isCreated) {
                    System.out.printf("Successfully created new file, path: %s\n", loginFile.getCanonicalFile());
                } else {
                    System.out.println("File already existed");
                }
                scanner.close();
            }
            

            // if (input.equals("users")) {
            //     //Creating a File object for directory
            //     File directoryPath = new File(dirPath);

            //     //List of all files and directories
            //     String contents[] = directoryPath.list();
            //     System.out.println("List of files and directories in the specified directory:");
            //     for(int i=0; i<contents.length; i++) {
            //         System.out.println(contents[i]);
            //     }
            // }

            // if (input.equals("list")) {
            //     cartItems = new ArrayList<String>();

            //     // File path is passed as parameter
            //     File file = new File(dirPath + File.separator + stringLogin);

            //     // Creating an object of BufferedReader class
            //     BufferedReader br = new BufferedReader(new FileReader(file));

            //     // Declaring a string variable
            //     String st;
            //     // Condition holds true till there is character in a string
            //     while ((st = br.readLine()) != null) {
            //         // Print the string
            //         System.out.println(st);

            //         cartItems.add(st);
            //     }

            //     br.close();

                // if (cartItems.size() > 0) {
                //     // for (String item: cartItems)
                //     // System.out.printf("%s\n", item);

                //     for (int i = 0; i < cartItems.size(); i++)
                //         System.out.printf("%d: %s\n", i, cartItems.get(i));
                // } else {
                //     System.out.println("Your cart is empty");
                // }
            }    
    }
}