// Sam Pirkl

public class User {

    private ArrayList<Data> userData;
    private String name, hashAlg, hash;
    public User(String name, String hashAlg, String hash) {
        this.name = name;
        this.hashAlg = hashAlg;
        this.hash = hash;
        userData = new ArrayList<Data>();
    }

    public String getName() { return name; }
    public String getHashAlg() { return hashAlg; }
    public String getHash() { return hash; }
}