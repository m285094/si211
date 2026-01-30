// Sam Pirkl

import java.util.*;
import java.io.*;

public class Proj01 {

    public static void main(String[] args) {

        if(args.length == 0) { //error if user doesn't enter file
            System.out.println("usage: java Proj01 <sectionsfile>");
            System.exit(1);
        }
        
        //init file reader scanner and array to hold sections
        Scanner fin = null;
        Section[] sections = new Section[11];
        try { 

            fin = new Scanner(new FileReader(args[0])); //read file from input
            int index = 0; //index to count pos in array
            while(fin.hasNext()) //loop through until can't read anymore
                sections[index++] = new Section(fin.next(), fin.next(), fin.next(), fin.next());

        } catch(IOException e) { //error if the file doesnt exist

            e.printStackTrace();
            System.exit(1); 
        }

        //make scanner to read user input
        Scanner sc = new Scanner(System.in);
        System.out.print("> ");
        while(sc.hasNext()) { //loop while there's input

            String cmd = sc.next();
            if(cmd.equals("sections")) //if user wants sections
                Section.printSections(sections, sc.next()); //print sections
            else if(cmd.equals("quit")) //leave while loop if quit
                break;
            else
                System.out.println("Unknown command: " + cmd);

            System.out.print("> ");
        }
    }
}