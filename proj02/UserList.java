
public class UserList extends List<User> {

    private static Hasher[] H = {new Padcut(), new ShiftCaesar(), new ShiftVigenere()};
    public UserList() {
        super();
    }

    public void add(String name, String hashAlg, String hash) {
        super.add(new User(name, hashAlg, hash));
    }

    // check to see if password matches user
    public boolean login(String uname, char[] pswd) throws Exception {
        
        // loop through users in list
        for(User user : list) {

            // if there's a user that matches prompted username
            if(user.getName().equals(uname)) {

                String hash = computeNewUserHash(user.getHashAlg(), pswd);
                if(user.getHash().equals(hash))
                    return true;
            }
        }

        return false;
    }

    public static String computeNewUserHash(String hashAlg, char[] pswd) throws IllegalCharException, Exception {

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
        for(User user : list) {
            if(username.equals(user.getName())) {
                System.out.println("Error! Username '" + username + "' already in use.");
                return true;
            }
        }

        return false;
    }
}