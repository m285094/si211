// Sam Pirkl and Sean Beckford

import si211.*;
import java.io.*;
import java.util.*;

public class Lab06 {
    public static void main(String[] args) {
        if (args.length == 0) { //print error if user doesn't pass in filename
        System.out.println("usage: java Lab06 <filename>");
        System.exit(1);
        }

        // file processing
        Scanner fin = null;
        try { fin = new Scanner(new FileReader(args[0])); }
        catch(IOException e) { // error if file doesn't exist
            e.printStackTrace();
            System.exit(1);
        }

        TweetQueueIter t = new TweetQueueIter(fin); //make new queue iterator
        TweetQueueIter original = t; // make copy of original list
        int count = t.getTweets(); // get number of tweets 
        System.out.println(count + " tweets"); // and print original count

        String cmd = "";
        Scanner sc = new Scanner(System.in);
        do { // loop until user quits
            System.out.print("> ");
            cmd = sc.next();
            if (cmd.equals("dump")) {
                t.printDump();
            }
            if (cmd.equals("filter")) {
                t = t.filter(sc.next());
            }
            if (cmd.equals("filter!")) {
                t = t.filterNot(sc.next());
            }
            if (cmd.equals("reset")) {
                t = original; // make queue list equal to original
                t.resetNumTweets(); // reset and print num tweets
                System.out.println(t.getTweets() + " tweets");
            }
        } while(!cmd.equals("quit"));
    }
}