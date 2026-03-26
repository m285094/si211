// Sam Pirkl

import java.util.*;
import java.io.*;
public class Vault {

    public static String getUsername() {
        System.out.print("username: ");
        return System.console().readLine();
    }

    public static char[] getPassword() {
        System.out.print("password: ");
        return System.console().readPassword();
    }
    
    public static void main(String[] args) {

        if(args.length == 0) {
            System.out.println("usage: java Vault [-au] <filename>");
            System.exit(1);
        }

        String fname = (args.length > 1) ? args[1] : args[0];
        Scanner fin;
        UserList L = new UserList();
        try {
            fin = new Scanner(new FileReader(fname));

            while(fin.hasNext()) {
                fin.next();
                L.addUser(fin.next(), fin.next(), fin.next());
            }
        } catch(IOException e) {
            System.out.println("Error! File '"+fname+"' could not be opened.");
            System.exit(1);
        } catch(NoSuchElementException e) {
            System.out.println("Error! File '"+fname+"' improperly formatted.");
            System.exit(1);
        }

        if(args.length > 1) { // if user is prompting to add user

            PrintWriter pw = null;
            try {
                pw = new PrintWriter(fname);
                L.printUsersToFile(pw); // ERROR - does not write back to the file even if it fails the padcut bc password has $
            } catch(FileNotFoundException fnfe) {
                fnfe.printStackTrace();
            }

            String username = getUsername();
            char[] password = getPassword();
            System.out.print("Hash algorithm: ");
            String hashAlg = System.console().readLine();

            if(L.checkIfUserExists(username))
                System.exit(0);

            try {
                pw.println("user " + username + " " + hashAlg + " " + UserList.computeNewUserHash(hashAlg, password));
            } catch(Exception e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }

            pw.close();
            System.exit(0);
        }

        String username = getUsername();
        char[] password = getPassword();

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