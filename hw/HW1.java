// Sam Pirkl

import java.util.*;
import java.io.*;

public class HW1 {
  public static void main(String[] args) {

    LineNumberReader lr = null;
    // check if file is inputted
    if(args.length > 0) {

        try { // make line number reader with file in
            lr = new LineNumberReader(new FileReader(args[0]));
        } catch(IOException e) { // print error if file doesnt exist
            System.out.println("File \"" + args[0] +"\" not found");
            System.exit(1);
        }
    } else { // otherwise make line number reader with stdin
        lr = new LineNumberReader(new InputStreamReader(System.in));
    }

    Scanner sc = new Scanner(lr);
    try { // compute number
        System.out.println(Mystery.compute(sc));
    } catch(Exception e) { // print error with line number
        System.out.println("Error " + e.getMessage() + " at line " + lr.getLineNumber());
    }
  }
}