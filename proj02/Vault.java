// Sam Pirkl

import java.util.*;
import java.io.*;
public class Vault {
    
    public static void main(String[] args) {

        if(args.length == 0) {
            System.out.println("usage: java Vault [-au] <filename>");
            System.exit(1);
        }

        Scanner fin;
        // ArrayList<User> users = new ArrayList<User>();
        UserList L = new UserList();
        try {
            fin = new Scanner(new FileReader(args[0]));

            while(fin.hasNext()) {
                fin.next();
                // users.add(new User(sc.next(), sc.next(), sc.next()));
                L.addUser(fin.next(), fin.next(), fin.next());
            }
        } catch(IOException e) {
            System.out.println("Error! File '"+args[0]+"' could not be opened.");
            // e.printStackTrace();
            System.exit(1);
        } catch(NoSuchElementException e) {
            System.out.println("Error! File '"+args[0]+"' improperly formatted.");
            System.exit(1);
        }

        // Get  from user
        System.out.print("username: ");
        String username = System.console().readLine();
        System.out.print("password: ");
        char[] password = System.console().readPassword();

        boolean access = false;
        try {
            if(L.login(username, password)) {
                System.out.println("Access granted!");
                access = true;
            } else
                System.out.println("Access denied!");
        } catch(IllegalCharException e) {
            System.out.println("Access denied!");
            System.exit(1);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        Scanner sc = new Scanner(System.in);
        String cmd = "";
        while(access && !cmd.equals("quit")) {
            System.out.print("> ");
            cmd = sc.next();

        }
    }
}