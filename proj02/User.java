// Sam Pirkl

public class User {

    private String name, hashAlg, hash;
    public User(String name, String hashAlg, String hash) {
        this.name = name;
        this.hashAlg = hashAlg;
        this.hash = hash;
    }

    public String getName() { return name; }
    public String getHashAlg() { return hashAlg; }
    public String getHash() { return hash; }
}