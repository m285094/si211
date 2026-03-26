// Sam Pirkl

import java.util.*;
import java.io.*;

public class Lab09b
{
      public static void main(String[] args)
      {

            // initialize variables for printing and file reading
            boolean verbose = false;
            String fname = null;

            if(args.length > 0) { // if the user passed args into cli
                  if(args[0].equals("-v")) { // if the first arg is -v
                        verbose = true; // then its in verbose mode
                        if(args.length > 1) // and if there's one more arg
                              fname = args[1]; // it must be the file name
                  } else {
                        fname = args[0]; // file name can come first
                        if(args.length > 1)
                              verbose = true; // and then -v is second
                  }
            }

            Scanner sc;
            if(fname == null) { // if the file name wasn't initialized, then read from stdin
                  sc = new Scanner(System.in);
            } else {
                  try { sc = new Scanner(new FileReader(fname)); } 
                  catch(IOException e) { // if opening file doesn't work
                        System.out.println("File '" + fname + "' could not be opened; switching input to standard in.");
                        sc = new Scanner(System.in); // set scanner back to stdin
                        fname = null; // make fname null to tell whether to print > or not
                  }
            }

            ModQueue Q = new ModQueue();
            do {
                  // determine if reading from file or stdin
                  if (fname == null) System.out.print("> ");

                  // try block to attempt instruction in case of ctrl d
                  try {
                        String s = sc.next(); // get command
                        if(s.equals("quit")) {
                              break;
                        } else if(s.equals("add")) {
                              try {
                                    String word = sc.next();  
                                    Q.enqueue(word);
                              } catch (NoSuchElementException e) { // if user enters ctrl d before second word
                                    System.out.println("Unexpected end of input.");
                                    break;  
                              }
                        } else if(s.equals("clearto")) {
                              try {
                                    String word = sc.next();  
                                    try {
                                          Q.dequeue(word);  
                                    } catch(Exception e) { // if word is not in list
                                          if(verbose)
                                                System.out.println("String '" + word + "' not found!");
                                    }
                              } catch (NoSuchElementException e) { // if user enters ctrl d before second word
                                    System.out.println("Unexpected end of input.");
                                    break;
                              }
                        } else if(s.equals("dump")) {
                              try { 
                                    System.out.println(Q.dump());
                              } catch(Exception e) { /* ignore */ } 
                        } else { // print unknown command if not one of the above
                              if(verbose)
                                    System.out.println("Unknown command '" + s + "'.");
                        }
                  // final check to see if user quit before command processed
                  } catch(NoSuchElementException e) { 
                        System.out.println("Unexpected end of input.");
                        break; 
                  }
            } while(true);
      }
}
