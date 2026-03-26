// Sam Pirkl

import java.util.*;
import java.io.*;

public class UserList {

    private static Hasher[] H = {new Padcut(), new ShiftCaesar(), new ShiftVigenere()};
    private ArrayList<User> users;
    public UserList() {
        users = new ArrayList<User>();
    }

    // add user to the arraylist
    public void addUser(String name, String hashAlg, String hash) {
        users.add(new User(name, hashAlg, hash));
    }

    // check to see if password matches user
    public boolean login(String uname, char[] pswd) throws Exception {
        
        // loop through users in list
        for(User user : users) {

            // if there's a user that matches prompted username
            if(user.getName().equals(uname)) {

                String hash = computeNewUserHash(user.getHashAlg(), pswd);
                // // find hasher (throw exception if not found)
                // int i = 0;
                // while(i < H.length && !H[i].getAlgName().equals(user.getHashAlg()))
                //     i++;
                // if (i == H.length)
                //     throw new Exception("Error! Hash algorithm '"+user.getHashAlg()+"' not supported.");
                // Hasher h = H[i];

                // // initialize hasher if hashed password matches users hash
                // h.init(pswd);
                if(user.getHash().equals(hash))
                    return true;
            }
        }

        return false;
    }

    public static String computeNewUserHash(String hashAlg, char[] pswd) throws Exception {

        // find hasher (throw exception if not found)
        int i = 0;
        while(i < H.length && !H[i].getAlgName().equals(hashAlg))
            i++;
        if (i == H.length)
            throw new Exception("Error! Hash algorithm '"+hashAlg+"' not supported.");
        Hasher h = H[i];

        h.init(pswd);
        return h.computeHash(pswd);
    }

    public void printUsersToFile(PrintWriter pw) {

        for(User user : users) {
            pw.println("user " + user.getName() + " " + user.getHashAlg() + " " + user.getHash());
        }
    }

    public boolean checkIfUserExists(String username) {
        for(User user : users) {
            if(username.equals(user.getName())) {
                System.out.println("Error! Username '" + username + "' already in use.");
                return true;
            }
        }

        return false;
    }
}