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
        NodeList sections = new NodeList();
        try { 

            fin = new Scanner(new FileReader(args[0])); //read file from input
            while(fin.hasNext()) {//loop through until can't read anymore
                Section s = new Section(fin.next(), fin.next(), fin.next(), fin.next());
                sections.addToBack(s); //add to back for correct order
            }

        } catch(IOException e) { //error if the file doesnt exist

            e.printStackTrace();
            System.exit(1); 
        }

        //make scanner to read user input
        Scanner sc = new Scanner(System.in);
        Schedule schedule = new Schedule(); //make a new schedule object
        String cmd; //string to read in commands

        System.out.print("> ");
        while(!(cmd = sc.next()).equals("quit")) { //loop while there's input

            if(cmd.equals("sections")) //if user wants sections
                sections.printNodes(sc.next()); //print sections
            else if(cmd.equals("add"))
                schedule.addToSchedule(sections, sc.next(), sc.next()); //add to schedule
            else if(cmd.equals("show"))
                schedule.printSchedule(); //print schedule
            else if(cmd.equals("week"))
                schedule.getWeek().printWeek(); //print grid of schedule
            else if(cmd.equals("fit"))
                schedule.getWeek().fits(sections, schedule, sc.next());
            else
                System.out.println("Unknown command: " + cmd);

            System.out.print("> ");
        }
    }
}